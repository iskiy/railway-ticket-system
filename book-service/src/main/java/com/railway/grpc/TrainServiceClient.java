package com.railway.grpc;

import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainServiceClient {

    private final ManagedChannel channel;
    private final SeatReservationGrpc.SeatReservationBlockingStub stub;

    @Autowired
    public TrainServiceClient(ManagedChannel channel) {
        this.channel = channel;
        this.stub = SeatReservationGrpc.newBlockingStub(channel);
    }

    public Train.CheckSeatAvailabilityAndReserveResponse getBookingInfoAndCheckReservation(Long id) {
        Train.CheckSeatAvailabilityAndReserveRequest request = Train.CheckSeatAvailabilityAndReserveRequest.newBuilder()
                .setSeatId(id.intValue())
                .build();
        return stub.checkSeatAvailabilityAndReserve(request);
    }
}