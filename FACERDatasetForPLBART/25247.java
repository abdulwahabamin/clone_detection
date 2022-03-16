    protected SongDTO(Parcel in) {
        this.songTitle = in.readString();
        this.songDuration = in.readLong();
        this.songLocation = in.readString();
        this.albumId = in.readString();
        this.id = in.readString();
    }

