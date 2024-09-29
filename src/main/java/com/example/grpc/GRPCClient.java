package com.example.grpc;

import com.example.grpc.api.RPCDateRequest;
import com.example.grpc.api.RPCDateResponse;
import com.example.grpc.api.RPCDateServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;

public class GRPCClient {
    private static final String host = "localhost";
    private static final int serverPort = 9999;

    public static void main(String[] args) throws Exception {
        // 创建与服务端通信的通道（channel）
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host, serverPort)
                .usePlaintext() // 使用明文通信（未加密）
                .build();

        try {
            // 创建异步的非阻塞式stub来调用服务端的方法
            RPCDateServiceGrpc.RPCDateServiceStub rpcDateService = RPCDateServiceGrpc.newStub(managedChannel);

            // 使用CountDownLatch确保客户端在接收完所有服务端响应后再关闭
            CountDownLatch finishLatch = new CountDownLatch(1);

            // 创建一个StreamObserver来处理服务端的响应
            StreamObserver<RPCDateResponse> responseObserver = new StreamObserver<RPCDateResponse>() {
                @Override
                public void onNext(RPCDateResponse response) {
                    // 当服务端返回响应时调用，处理响应数据
                    System.out.println("Received response: " + response.getServerDate());
                }

                @Override
                public void onError(Throwable throwable) {
                    // 当处理过程中出现错误时调用
                    System.err.println("Error: " + throwable.getMessage());
                    finishLatch.countDown(); // 减少计数，表示请求完成
                }

                @Override
                public void onCompleted() {
                    // 当服务端完成所有响应时调用
                    System.out.println("All responses received.");
                    finishLatch.countDown(); // 减少计数，表示所有请求完成
                }
            };

            // 创建双向流的请求观察者
            StreamObserver<RPCDateRequest> requestObserver = rpcDateService.getDate(responseObserver);

            // 客户端发送多个请求，每次发送一个用户名
            for (String name : new String[]{"Anthony", "Bob", "Carol"}) {
                // 构建请求对象
                RPCDateRequest rpcDateRequest = RPCDateRequest.newBuilder().setUserName(name).build();

                // 发送请求
                requestObserver.onNext(rpcDateRequest);

                // 打印日志，显示当前发送的请求
                System.out.println("Sent request: " + name);
            }

            // 通知服务端，所有请求都已发送完毕
            requestObserver.onCompleted();

            // 等待服务端所有响应处理完成
            finishLatch.await();
        } finally {
            // 关闭通道，释放资源
            managedChannel.shutdown();
        }
    }

}
