    public Song(long _id, String filePath, String title, String album, long albumId,
                String albumArt, String artist, long artistId, long duration, String libraryUsername) {
        this._id = _id;
        this.filePath = filePath;
        this.title = title;
        if(album!=null && album.equals("<unknown>")) {
            this.album = "Unknown Album";
        } else {
            this.album = album;
        }
        this.albumId = albumId;
        this.albumArt = albumArt;
        if(artist!=null && artist.equals("<unknown>")) {
            this.artist = "Unknown Artist";
        } else {
            this.artist = artist;
        }
        this.artistId = artistId;
        this.duration = duration;
        this.libraryUsername = libraryUsername;
    }

