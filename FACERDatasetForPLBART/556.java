    protected FriendInfo(Parcel in) {
        friendId = in.readInt();
        friendNickName = in.readString();
        friendIconUrl = in.readString();
        deviceAddress = in.readString();
        identificationName = in.readString();
        joinTime = in.readString();
        isOnline = in.readByte() != 0;
        bluetoothDevice = in.readParcelable(BluetoothDevice.class.getClassLoader());
    }

