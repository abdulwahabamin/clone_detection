    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeInt(orderId);
        parcel.writeString(localeAbbrev);
        parcel.writeString(nickname);
        parcel.writeFloat(accuracy);
        parcel.writeString(locationSource);
        parcel.writeLong(lastLocationUpdate);
        parcel.writeParcelable(address, 0);
    }

