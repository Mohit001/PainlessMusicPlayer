// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.doctoror.fuckoffmusicplayer.data.settings.nano;

@SuppressWarnings("hiding")
public interface SettingsProto {

  public static final class Settings extends
      com.google.protobuf.nano.MessageNano {

    private static volatile Settings[] _emptyArray;
    public static Settings[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new Settings[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional int32 theme = 1;
    public int theme;

    // optional bool scrobbleEnabled = 2;
    public boolean scrobbleEnabled;

    public Settings() {
      clear();
    }

    public Settings clear() {
      theme = 0;
      scrobbleEnabled = false;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.theme != 0) {
        output.writeInt32(1, this.theme);
      }
      if (this.scrobbleEnabled != false) {
        output.writeBool(2, this.scrobbleEnabled);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.theme != 0) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(1, this.theme);
      }
      if (this.scrobbleEnabled != false) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeBoolSize(2, this.scrobbleEnabled);
      }
      return size;
    }

    @Override
    public Settings mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            this.theme = input.readInt32();
            break;
          }
          case 16: {
            this.scrobbleEnabled = input.readBool();
            break;
          }
        }
      }
    }

    public static Settings parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new Settings(), data);
    }

    public static Settings parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new Settings().mergeFrom(input);
    }
  }
}
