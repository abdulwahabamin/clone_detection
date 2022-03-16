    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.albumTitle);
        dest.writeTypedList(this.songs);
        dest.writeString(this.id);
        dest.writeString(this.artistId);
        dest.writeString(this.coverPath);
    }

