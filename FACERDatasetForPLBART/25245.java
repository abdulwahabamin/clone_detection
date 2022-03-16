    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.songTitle);
        dest.writeLong(this.songDuration);
        dest.writeString(this.songLocation);
        dest.writeString(this.albumId);
        dest.writeString(this.id);
    }

