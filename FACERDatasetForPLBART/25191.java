    protected AlbumDTO(Parcel in) {
        this.albumTitle = in.readString();
        this.songs = new ArrayList<>();
        in.readTypedList(this.songs, SongDTO.CREATOR);
        this.id = in.readString();
        this.artistId = in.readString();
        this.coverPath = in.readString();
    }

