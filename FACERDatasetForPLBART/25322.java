    public static RhythmSong getSongMeta(String songLocation) {
        MusicMetaData musicMetaData = new MusicMetaData(songLocation);
        String artist = musicMetaData.getArtistName() != null ? musicMetaData.getArtistName() : "Unknown Artist";
        String album = musicMetaData.getAlbumName() != null ? musicMetaData.getAlbumName() : "Unknown Album";
        String track = musicMetaData.getSongTitle() != null ? musicMetaData.getSongTitle() : "Unknown Track";
        byte[] imageData = musicMetaData.getAlbumArt();
        long duration = musicMetaData.getDuration() / 1000;
        return new RhythmSong.RhythmSongBuilder().songLocation(songLocation).artistTitle(artist).albumTitle(album)
                .trackTitle(track).imageData(imageData).duration(duration).build();
    }

