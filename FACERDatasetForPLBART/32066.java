    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(weatherId);
        parcel.writeString(icon);
        parcel.writeString(description);
    }

