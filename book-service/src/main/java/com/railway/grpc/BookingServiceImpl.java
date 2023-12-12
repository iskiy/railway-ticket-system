//package com.railway.grpc;
//
//import com.railway.model.BookingEntity;
//import com.railway.service.BookingService;
//import io.grpc.Status;
//import io.grpc.stub.StreamObserver;
//import lombok.RequiredArgsConstructor;
//import org.lognet.springboot.grpc.GRpcService;
//import org.springframework.stereotype.Service;
//
//@Service
//@GRpcService
//@RequiredArgsConstructor
//public class BookingServiceImpl extends BookingServiceGrpc.BookingServiceImplBase {
//
//    private final BookingService bookingService;
//
//    @Override
//    public void getBookingInfoAndCheckReservation(Booking.GetBookingInfoAndCheckReservationRequest request,
//                                                  StreamObserver<Booking.GetBookingInfoAndCheckReservationResponse> responseObserver) {
//        // super.getBookingInfoAndCheckReservation(request, responseObserver);
//        try {
//            BookingEntity bookingEntity = bookingService.getBookingById((long) request.getBookingId());
//            if (bookingEntity == null) {
//                responseObserver.onError(Status.NOT_FOUND
//                        .withDescription("Booking not found")
//                        .asRuntimeException());
//            } else {
//                Booking.BookingStatus status = switch (bookingEntity.getStatus()) {
//                    case Booked -> Booking.BookingStatus.Booked;
//                    case NotBooked -> Booking.BookingStatus.NotBooked;
//                    case YetBooked -> Booking.BookingStatus.YetBooked;
//                    case Unknown -> Booking.BookingStatus.Unknown;
//                };
//                Long bookingId = bookingEntity.getBookingId();
//                Long seatId = bookingEntity.getBookingId();
//                Booking.GetBookingInfoAndCheckReservationResponse response = Booking.GetBookingInfoAndCheckReservationResponse.newBuilder()
//                        .setBookingId(bookingId.intValue())
//                        .setSeatId(seatId.intValue())
//                        .setUserEmail(bookingEntity.getUserEmail())
//                        .setStatus(status)
//                        .build();
//
//                responseObserver.onNext(response);
//                responseObserver.onCompleted();
//            }
//        } catch (Exception e) {
//            responseObserver.onError(Status.INTERNAL
//                    .withDescription("Internal server error")
//                    .asRuntimeException());
//        }
//    }
//
//    @Override
//    public void removeBooking(Booking.RemoveBookingRequest request, StreamObserver<Booking.RemoveBookingResponse> responseObserver) {
//        // super.removeBooking(request, responseObserver);
//        try {
//            bookingService.deleteBookingById((long) request.getBookingId());
//            Booking.RemoveBookingResponse response = Booking.RemoveBookingResponse.newBuilder()
//                            .setSuccess(true)
//                            .setMessage("Klasni")
//                            .build();
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//        } catch (Exception e) {
//            Booking.RemoveBookingResponse response = Booking.RemoveBookingResponse.newBuilder()
//                    .setSuccess(false)
//                    .setMessage("Uzhasni")
//                    .build();
//            responseObserver.onNext(response);
//            responseObserver.onError(Status.INTERNAL
//                    .withDescription("Internal server error")
//                    .asRuntimeException());
//        }
//    }
//}
