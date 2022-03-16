    protected ArtistDTO(Parcel in) {
        this.id = in.readString();
        this.artistName = in.readString();
        this.albumDTOList = new ArrayList<>();
        in.readTypedList(this.albumDTOList, AlbumDTO.CREATOR);
        this.coverPath = in.readString();
    }

