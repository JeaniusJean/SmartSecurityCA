// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartAlarms.proto

package grpc.smartalarms;

public final class SmartAlarmsImpl {
  private SmartAlarmsImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smokeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smokeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smokeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smokeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sensorRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sensorRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sensorResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sensorResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021smartAlarms.proto\"\035\n\014smokeRequest\022\r\n\005s" +
      "moke\030\001 \001(\t\"5\n\rsmokeResponse\022\020\n\010latitude\030" +
      "\001 \001(\005\022\022\n\nlongtitude\030\002 \001(\005\"\037\n\rsensorReque" +
      "st\022\016\n\006sensor\030\001 \001(\t\"%\n\016sensorResponse\022\023\n\013" +
      "sensorAlarm\030\001 \001(\t2r\n\013smartAlarms\022/\n\nsmok" +
      "eAlarm\022\r.smokeRequest\032\016.smokeResponse\"\0000" +
      "\001\0222\n\013alarmSystem\022\016.sensorRequest\032\017.senso" +
      "rResponse\"\000(\001B%\n\020grpc.smartalarmsB\017Smart" +
      "AlarmsImplP\001b\006proto3"
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
    internal_static_smokeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smokeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smokeRequest_descriptor,
        new java.lang.String[] { "Smoke", });
    internal_static_smokeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smokeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smokeResponse_descriptor,
        new java.lang.String[] { "Latitude", "Longtitude", });
    internal_static_sensorRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_sensorRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sensorRequest_descriptor,
        new java.lang.String[] { "Sensor", });
    internal_static_sensorResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_sensorResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sensorResponse_descriptor,
        new java.lang.String[] { "SensorAlarm", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
