    public Song(long songId,
                String songTitle,
                String songArtist,
                String songAlbum,
                String songAlbumSortName,
                long songAlbumId,
                String songComposer,
                int songTrack) {
        id = songId;
        if (songTitle != null)
            title = songTitle.trim();
        if (songArtist != null)
            artist = songArtist.trim();
        if (songAlbum != null)
            album = songAlbum.trim();
        if (songAlbumSortName != null)
            albumSortTitle = songAlbumSortName;
        albumId = songAlbumId;
        if (songComposer != null)
            composer = songComposer.trim();
        track = songTrack;
    }

