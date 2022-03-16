    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.playlistName);
        dest.writeString(this.id);
        dest.writeInt(this.contentType == null ? -1 : this.contentType.ordinal());
    }

