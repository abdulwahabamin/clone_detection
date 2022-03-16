    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(groupId);
        parcel.writeInt(onlineNumber);
        parcel.writeString(groupName);
        parcel.writeTypedList(friendList);
    }

