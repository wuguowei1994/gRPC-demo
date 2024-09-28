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
            private final StringBuilder allNames = new StringBuilder();

            @Override
            public void onNext(RPCDateRequest request) {
                // 每当客户端发送一个请求时，onNext方法就会被调用
                if (allNames.length() > 0) {
                    allNames.append(", ");
                }
                allNames.append(request.getUserName());
            }

            @Override
            public void onError(Throwable t) {
                // 如果在接收请求时出错，onError方法会被调用
                System.err.println("Error receiving request: " + t.getMessage());
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                // 当客户端完成所有请求发送后，onCompleted方法会被调用
                String responseMessage = String.format("Hello: %s, today's date is %s.",
                        allNames,
                        LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                RPCDateResponse rpcDateResponse = RPCDateResponse
                        .newBuilder()
                        .setServerDate(responseMessage)
                        .build();

                // 通过responseObserver返回一个响应
                responseObserver.onNext(rpcDateResponse);
                responseObserver.onCompleted();
            }
        };
    }
}
