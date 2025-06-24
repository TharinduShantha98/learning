package com.learning.tutorials.service;
;

import com.learning.tutorials.entity.EmployeeEntity;
import com.learning.tutorials.grpc.EmployeeRequest;
import com.learning.tutorials.grpc.EmployeeResponse;
import com.learning.tutorials.grpc.EmployeeServiceGrpc;
import com.learning.tutorials.repo.EmployeeRepo;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

import java.util.Optional;

@GrpcService
public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void getEmployee(EmployeeRequest request, StreamObserver<EmployeeResponse> responseObserver) {

        int employeeId = request.getEmployeeId();
        Optional<EmployeeEntity> byId = employeeRepo.findById(employeeId);
        if(byId.isEmpty()){
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Employee with ID "+ employeeId + " not found")
                            .asException()
            );

            return;
        }
        EmployeeEntity employeeEntity = byId.get();
        EmployeeResponse employeeResponse = EmployeeResponse.newBuilder()
                .setEmployeeId(employeeEntity.getEmployeeID())
                .setAddress("colombo")
                .setName(employeeEntity.getFirstName())
                .build();
        responseObserver.onNext(employeeResponse);
        responseObserver.onCompleted();

    }
}
