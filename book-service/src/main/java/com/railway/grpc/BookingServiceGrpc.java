package com.railway.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: booking.proto")
public final class BookingServiceGrpc {

  private BookingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.railway.grpc.BookingService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest,
      com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse> METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION =
      io.grpc.MethodDescriptor.<com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest, com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.railway.grpc.BookingService", "GetBookingInfoAndCheckReservation"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.railway.grpc.Booking.RemoveBookingRequest,
      com.railway.grpc.Booking.RemoveBookingResponse> METHOD_REMOVE_BOOKING =
      io.grpc.MethodDescriptor.<com.railway.grpc.Booking.RemoveBookingRequest, com.railway.grpc.Booking.RemoveBookingResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.railway.grpc.BookingService", "RemoveBooking"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.railway.grpc.Booking.RemoveBookingRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.railway.grpc.Booking.RemoveBookingResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookingServiceStub newStub(io.grpc.Channel channel) {
    return new BookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BookingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBookingInfoAndCheckReservation(com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest request,
        io.grpc.stub.StreamObserver<com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION, responseObserver);
    }

    /**
     */
    public void removeBooking(com.railway.grpc.Booking.RemoveBookingRequest request,
        io.grpc.stub.StreamObserver<com.railway.grpc.Booking.RemoveBookingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_REMOVE_BOOKING, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION,
            asyncUnaryCall(
              new MethodHandlers<
                com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest,
                com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse>(
                  this, METHODID_GET_BOOKING_INFO_AND_CHECK_RESERVATION)))
          .addMethod(
            METHOD_REMOVE_BOOKING,
            asyncUnaryCall(
              new MethodHandlers<
                com.railway.grpc.Booking.RemoveBookingRequest,
                com.railway.grpc.Booking.RemoveBookingResponse>(
                  this, METHODID_REMOVE_BOOKING)))
          .build();
    }
  }

  /**
   */
  public static final class BookingServiceStub extends io.grpc.stub.AbstractStub<BookingServiceStub> {
    private BookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceStub(channel, callOptions);
    }

    /**
     */
    public void getBookingInfoAndCheckReservation(com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest request,
        io.grpc.stub.StreamObserver<com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeBooking(com.railway.grpc.Booking.RemoveBookingRequest request,
        io.grpc.stub.StreamObserver<com.railway.grpc.Booking.RemoveBookingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_REMOVE_BOOKING, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookingServiceBlockingStub extends io.grpc.stub.AbstractStub<BookingServiceBlockingStub> {
    private BookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse getBookingInfoAndCheckReservation(com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION, getCallOptions(), request);
    }

    /**
     */
    public com.railway.grpc.Booking.RemoveBookingResponse removeBooking(com.railway.grpc.Booking.RemoveBookingRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_REMOVE_BOOKING, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookingServiceFutureStub extends io.grpc.stub.AbstractStub<BookingServiceFutureStub> {
    private BookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse> getBookingInfoAndCheckReservation(
        com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.railway.grpc.Booking.RemoveBookingResponse> removeBooking(
        com.railway.grpc.Booking.RemoveBookingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_REMOVE_BOOKING, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BOOKING_INFO_AND_CHECK_RESERVATION = 0;
  private static final int METHODID_REMOVE_BOOKING = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BOOKING_INFO_AND_CHECK_RESERVATION:
          serviceImpl.getBookingInfoAndCheckReservation((com.railway.grpc.Booking.GetBookingInfoAndCheckReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.railway.grpc.Booking.GetBookingInfoAndCheckReservationResponse>) responseObserver);
          break;
        case METHODID_REMOVE_BOOKING:
          serviceImpl.removeBooking((com.railway.grpc.Booking.RemoveBookingRequest) request,
              (io.grpc.stub.StreamObserver<com.railway.grpc.Booking.RemoveBookingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class BookingServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.railway.grpc.Booking.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookingServiceDescriptorSupplier())
              .addMethod(METHOD_GET_BOOKING_INFO_AND_CHECK_RESERVATION)
              .addMethod(METHOD_REMOVE_BOOKING)
              .build();
        }
      }
    }
    return result;
  }
}
