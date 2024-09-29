package com.example.grpc;

import com.example.grpc.api.RPCDateRequest;
import com.example.grpc.api.RPCDateResponse;
import com.example.grpc.api.RPCDateServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RPCDateServiceImpl extends RPCDateServiceGrpc.RPCDateServiceImplBase {

    @Override
    public StreamObserver<RPCDateRequest> getDate(StreamObserver<RPCDateResponse> responseObserver) {
        return new StreamObserver<RPCDateRequest>() {
            @Override
            public void onNext(RPCDateRequest request) {
                // 每当接收到一个请求时处理
                String userName = request.getUserName();
                String response = String.format("你好: %s, 今天是 %s.", userName, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                // 创建响应并发送
                RPCDateResponse rpcDateResponse = RPCDateResponse.newBuilder().setServerDate(response).build();
                responseObserver.onNext(rpcDateResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                // 当客户端完成请求时调用
                responseObserver.onCompleted();
                System.out.println("All requests processed.");
            }
        };
    }
}
