//package com.railway.grpc;
//
//import io.grpc.ManagedChannel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BookingServiceClient {
//
//    private final ManagedChannel channel;
//    private final BookingServiceGrpc.BookingServiceBlockingStub stub;
//
//    @Autowired
//    public BookingServiceClient(ManagedChannel channel) {
//        this.channel = channel;
//        this.stub = BookingServiceGrpc.newBlockingStub(channel);
//    }
//
//    public Booking.GetBookingInfoAndCheckReservationResponse getBookingInfoAndCheckReservation(Long id) {
//        Booking.GetBookingInfoAndCheckReservationRequest request = Booking.GetBookingInfoAndCheckReservationRequest.newBuilder()
//                .setBookingId(id.intValue())
//                .build();
//        return stub.getBookingInfoAndCheckReservation(request);
//    }
//
//    public Booking.RemoveBookingResponse removeBooking(Long id) {
//        Booking.RemoveBookingRequest request = Booking.RemoveBookingRequest.newBuilder()
//                .setBookingId(id.intValue())
//                .build();
//        return stub.removeBooking(request);
//    }
//}