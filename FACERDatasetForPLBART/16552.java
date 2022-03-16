    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mediaItem, flags);
        dest.writeString(typeTitle);
        dest.writeInt(category);
    }

