    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.artistTitle);
        dest.writeString(this.albumTitle);
        dest.writeString(this.trackTitle);
        dest.writeByteArray(this.imageData);
        dest.writeFloat(this.duration);
        dest.writeString(this.songLocation);
    }

