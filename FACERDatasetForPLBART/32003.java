    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeLong(voiceSettingId);
        parcel.writeInt(paramTypeId);
        parcel.writeInt(mapBooleanToInt(paramBooleanValue));
        parcel.writeLong(paramLongValue);
        parcel.writeString(paramStringValue);
    }

