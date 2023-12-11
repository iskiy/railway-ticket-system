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
    comments = "Source: train.proto")
public final class SeatReservationGrpc {

  private SeatReservationGrpc() {}

  public static final String SERVICE_NAME = "com.railway.grpc.SeatReservation";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest,
      com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse> METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE =
      io.grpc.MethodDescriptor.<com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest, com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.railway.grpc.SeatReservation", "CheckSeatAvailabilityAndReserve"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SeatReservationStub newStub(io.grpc.Channel channel) {
    return new SeatReservationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SeatReservationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SeatReservationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SeatReservationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SeatReservationFutureStub(channel);
  }

  /**
   */
  public static abstract class SeatReservationImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkSeatAvailabilityAndReserve(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest request,
        io.grpc.stub.StreamObserver<com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE,
            asyncUnaryCall(
              new MethodHandlers<
                com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest,
                com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse>(
                  this, METHODID_CHECK_SEAT_AVAILABILITY_AND_RESERVE)))
          .build();
    }
  }

  /**
   */
  public static final class SeatReservationStub extends io.grpc.stub.AbstractStub<SeatReservationStub> {
    private SeatReservationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SeatReservationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeatReservationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SeatReservationStub(channel, callOptions);
    }

    /**
     */
    public void checkSeatAvailabilityAndReserve(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest request,
        io.grpc.stub.StreamObserver<com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SeatReservationBlockingStub extends io.grpc.stub.AbstractStub<SeatReservationBlockingStub> {
    private SeatReservationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SeatReservationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeatReservationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SeatReservationBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse checkSeatAvailabilityAndReserve(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SeatReservationFutureStub extends io.grpc.stub.AbstractStub<SeatReservationFutureStub> {
    private SeatReservationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SeatReservationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SeatReservationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SeatReservationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse> checkSeatAvailabilityAndReserve(
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_SEAT_AVAILABILITY_AND_RESERVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SeatReservationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SeatReservationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_SEAT_AVAILABILITY_AND_RESERVE:
          serviceImpl.checkSeatAvailabilityAndReserve((com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest) request,
              (io.grpc.stub.StreamObserver<com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse>) responseObserver);
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

  private static final class SeatReservationDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.railway.grpc.Train.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SeatReservationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SeatReservationDescriptorSupplier())
              .addMethod(METHOD_CHECK_SEAT_AVAILABILITY_AND_RESERVE)
              .build();
        }
      }
    }
    return result;
  }
}
