    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mWeatherId);
        parcel.writeString(mDescription);
        parcel.writeString(mIdIcon);
    }

