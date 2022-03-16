    protected RhythmSong(Parcel in) {
        this.artistTitle = in.readString();
        this.albumTitle = in.readString();
        this.trackTitle = in.readString();
        this.imageData = in.createByteArray();
        this.duration = in.readLong();
        this.songLocation = in.readString();
    }

