package com.example.grpc;

import com.example.grpc.api.RPCDateRequest;
import com.example.grpc.api.RPCDateResponse;
import com.example.grpc.api.RPCDateServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RPCDateServiceImpl extends RPCDateServiceGrpc.RPCDateServiceImplBase {

    @Override
    public void getDate(RPCDateRequest request, StreamObserver<RPCDateResponse> responseObserver) {
        String userName = request.getUserName();

        // 这里模拟发送多个响应
        for (int i = 0; i < 5; i++) {
            String response = String.format("你好: %s, 今天是%s, index %s", userName, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), i);
            RPCDateResponse rpcDateResponse = RPCDateResponse.newBuilder().setServerDate(response).build();

            responseObserver.onNext(rpcDateResponse); // 发送响应
            try {
                Thread.sleep(1000); // 模拟延迟
            } catch (InterruptedException e) {
                responseObserver.onError(e);
                return;
            }
        }

        responseObserver.onCompleted(); // 完成响应流
    }
}
