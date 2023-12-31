// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: train.proto

package com.railway.grpc;

public final class Train {
  private Train() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CheckSeatAvailabilityAndReserveRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.railway.grpc.CheckSeatAvailabilityAndReserveRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 seat_id = 1;</code>
     */
    long getSeatId();
  }
  /**
   * Protobuf type {@code com.railway.grpc.CheckSeatAvailabilityAndReserveRequest}
   */
  public  static final class CheckSeatAvailabilityAndReserveRequest extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.railway.grpc.CheckSeatAvailabilityAndReserveRequest)
      CheckSeatAvailabilityAndReserveRequestOrBuilder {
    // Use CheckSeatAvailabilityAndReserveRequest.newBuilder() to construct.
    private CheckSeatAvailabilityAndReserveRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CheckSeatAvailabilityAndReserveRequest() {
      seatId_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private CheckSeatAvailabilityAndReserveRequest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              seatId_ = input.readUInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.class, com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.Builder.class);
    }

    public static final int SEAT_ID_FIELD_NUMBER = 1;
    private long seatId_;
    /**
     * <code>uint64 seat_id = 1;</code>
     */
    public long getSeatId() {
      return seatId_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (seatId_ != 0L) {
        output.writeUInt64(1, seatId_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (seatId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, seatId_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest)) {
        return super.equals(obj);
      }
      com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest other = (com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest) obj;

      boolean result = true;
      result = result && (getSeatId()
          == other.getSeatId());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + SEAT_ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getSeatId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.railway.grpc.CheckSeatAvailabilityAndReserveRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.railway.grpc.CheckSeatAvailabilityAndReserveRequest)
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.class, com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.Builder.class);
      }

      // Construct using com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        seatId_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_descriptor;
      }

      public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest getDefaultInstanceForType() {
        return com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.getDefaultInstance();
      }

      public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest build() {
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest buildPartial() {
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest result = new com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest(this);
        result.seatId_ = seatId_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest) {
          return mergeFrom((com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest other) {
        if (other == com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest.getDefaultInstance()) return this;
        if (other.getSeatId() != 0L) {
          setSeatId(other.getSeatId());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long seatId_ ;
      /**
       * <code>uint64 seat_id = 1;</code>
       */
      public long getSeatId() {
        return seatId_;
      }
      /**
       * <code>uint64 seat_id = 1;</code>
       */
      public Builder setSeatId(long value) {
        
        seatId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint64 seat_id = 1;</code>
       */
      public Builder clearSeatId() {
        
        seatId_ = 0L;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:com.railway.grpc.CheckSeatAvailabilityAndReserveRequest)
    }

    // @@protoc_insertion_point(class_scope:com.railway.grpc.CheckSeatAvailabilityAndReserveRequest)
    private static final com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest();
    }

    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CheckSeatAvailabilityAndReserveRequest>
        PARSER = new com.google.protobuf.AbstractParser<CheckSeatAvailabilityAndReserveRequest>() {
      public CheckSeatAvailabilityAndReserveRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new CheckSeatAvailabilityAndReserveRequest(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<CheckSeatAvailabilityAndReserveRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CheckSeatAvailabilityAndReserveRequest> getParserForType() {
      return PARSER;
    }

    public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface CheckSeatAvailabilityAndReserveResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.railway.grpc.CheckSeatAvailabilityAndReserveResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bool is_available = 1;</code>
     */
    boolean getIsAvailable();
  }
  /**
   * Protobuf type {@code com.railway.grpc.CheckSeatAvailabilityAndReserveResponse}
   */
  public  static final class CheckSeatAvailabilityAndReserveResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.railway.grpc.CheckSeatAvailabilityAndReserveResponse)
      CheckSeatAvailabilityAndReserveResponseOrBuilder {
    // Use CheckSeatAvailabilityAndReserveResponse.newBuilder() to construct.
    private CheckSeatAvailabilityAndReserveResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CheckSeatAvailabilityAndReserveResponse() {
      isAvailable_ = false;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private CheckSeatAvailabilityAndReserveResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              isAvailable_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.class, com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.Builder.class);
    }

    public static final int IS_AVAILABLE_FIELD_NUMBER = 1;
    private boolean isAvailable_;
    /**
     * <code>bool is_available = 1;</code>
     */
    public boolean getIsAvailable() {
      return isAvailable_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (isAvailable_ != false) {
        output.writeBool(1, isAvailable_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (isAvailable_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(1, isAvailable_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse)) {
        return super.equals(obj);
      }
      com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse other = (com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse) obj;

      boolean result = true;
      result = result && (getIsAvailable()
          == other.getIsAvailable());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + IS_AVAILABLE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsAvailable());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.railway.grpc.CheckSeatAvailabilityAndReserveResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.railway.grpc.CheckSeatAvailabilityAndReserveResponse)
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.class, com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.Builder.class);
      }

      // Construct using com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        isAvailable_ = false;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.railway.grpc.Train.internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_descriptor;
      }

      public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse getDefaultInstanceForType() {
        return com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.getDefaultInstance();
      }

      public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse build() {
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse buildPartial() {
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse result = new com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse(this);
        result.isAvailable_ = isAvailable_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse) {
          return mergeFrom((com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse other) {
        if (other == com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse.getDefaultInstance()) return this;
        if (other.getIsAvailable() != false) {
          setIsAvailable(other.getIsAvailable());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private boolean isAvailable_ ;
      /**
       * <code>bool is_available = 1;</code>
       */
      public boolean getIsAvailable() {
        return isAvailable_;
      }
      /**
       * <code>bool is_available = 1;</code>
       */
      public Builder setIsAvailable(boolean value) {
        
        isAvailable_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool is_available = 1;</code>
       */
      public Builder clearIsAvailable() {
        
        isAvailable_ = false;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:com.railway.grpc.CheckSeatAvailabilityAndReserveResponse)
    }

    // @@protoc_insertion_point(class_scope:com.railway.grpc.CheckSeatAvailabilityAndReserveResponse)
    private static final com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse();
    }

    public static com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CheckSeatAvailabilityAndReserveResponse>
        PARSER = new com.google.protobuf.AbstractParser<CheckSeatAvailabilityAndReserveResponse>() {
      public CheckSeatAvailabilityAndReserveResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new CheckSeatAvailabilityAndReserveResponse(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<CheckSeatAvailabilityAndReserveResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CheckSeatAvailabilityAndReserveResponse> getParserForType() {
      return PARSER;
    }

    public com.railway.grpc.Train.CheckSeatAvailabilityAndReserveResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013train.proto\022\020com.railway.grpc\"9\n&Check" +
      "SeatAvailabilityAndReserveRequest\022\017\n\007sea" +
      "t_id\030\001 \001(\004\"?\n\'CheckSeatAvailabilityAndRe" +
      "serveResponse\022\024\n\014is_available\030\001 \001(\0102\252\001\n\017" +
      "SeatReservation\022\226\001\n\037CheckSeatAvailabilit" +
      "yAndReserve\0228.com.railway.grpc.CheckSeat" +
      "AvailabilityAndReserveRequest\0329.com.rail" +
      "way.grpc.CheckSeatAvailabilityAndReserve" +
      "ResponseB?Z=github.com/iskiy/railway-tic" +
      "ket-system/train-service/protogenb\006proto",
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveRequest_descriptor,
        new java.lang.String[] { "SeatId", });
    internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_railway_grpc_CheckSeatAvailabilityAndReserveResponse_descriptor,
        new java.lang.String[] { "IsAvailable", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
