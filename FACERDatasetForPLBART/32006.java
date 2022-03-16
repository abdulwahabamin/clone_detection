    private VoiceSettingParameter(Parcel in) {
        id = in.readLong();
        voiceSettingId = in.readLong();
        paramTypeId = in.readInt();
        paramBooleanValue = mapIntToBoolean(in.readInt());
        paramLongValue = in.readLong();
        paramStringValue = in.readString();
    }

