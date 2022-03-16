    protected GroupInfo(Parcel in) {
        groupId = in.readInt();
        onlineNumber = in.readInt();
        groupName = in.readString();
        friendList = in.createTypedArrayList(FriendInfo.CREATOR);
    }

