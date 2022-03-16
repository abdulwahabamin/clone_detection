    protected MusicContent(Parcel in) {
        this.playlistName = in.readString();
        this.id = in.readString();
        int tmpContentType = in.readInt();
        this.contentType = tmpContentType == -1 ? null : ContentType.values()[tmpContentType];
    }

