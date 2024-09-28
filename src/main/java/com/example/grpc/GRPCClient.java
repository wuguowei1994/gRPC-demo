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
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(host, serverPort).usePlaintext().build();

        try {
            RPCDateServiceGrpc.RPCDateServiceStub rpcDateService = RPCDateServiceGrpc.newStub(managedChannel);
            RPCDateRequest rpcDateRequest = RPCDateRequest.newBuilder().setUserName("anthony").build();

            // 使用CountDownLatch确保所有响应接收完毕前程序不会退出
            CountDownLatch finishLatch = new CountDownLatch(1);

            // 使用StreamObserver接收流式响应
            StreamObserver<RPCDateResponse> responseObserver = new StreamObserver<RPCDateResponse>() {
                @Override
                public void onNext(RPCDateResponse response) {
                    System.out.println(response.getServerDate());
                }

                @Override
                public void onError(Throwable throwable) {
                    System.err.println("Error: " + throwable.getMessage());
                    finishLatch.countDown();
                }

                @Override
                public void onCompleted() {
                    System.out.println("All responses received.");
                    finishLatch.countDown();
                }
            };

            // 发送请求并开始接收响应
            rpcDateService.getDate(rpcDateRequest, responseObserver);

            // 等待所有响应处理完成
            finishLatch.await();
        } finally {
            managedChannel.shutdown();
        }
    }
}
