    public static List<Song> getSongsFromList(MusicContent musicContent, Context context) {
        switch (musicContent.getContentType()) {
            case ARTIST:
                //TODO: get all songs from artist
                return getArtistById(musicContent.getId(), context).getAlbums().get(0).getSongs();
            case ALBUM:
                return getAlbumById(musicContent.getId(), context).getSongs();
            case PLAYLIST:
                return getPlaylistById(musicContent.getId(), context).getSongs();
            case MOST_PLAYED:
                return getMostPlayedSongs(context);
            case LAST_PLAYED:
                return getLastPlayedSongs(context);
        }

        return null;
    }

