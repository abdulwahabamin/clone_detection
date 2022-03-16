    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(friendId);
        parcel.writeString(friendNickName);
        parcel.writeString(friendIconUrl);
        parcel.writeString(deviceAddress);
        parcel.writeString(identificationName);
        parcel.writeString(joinTime);
        parcel.writeByte((byte) (isOnline ? 1 : 0));
        parcel.writeParcelable(bluetoothDevice, i);
    }

