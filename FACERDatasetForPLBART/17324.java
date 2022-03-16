    public boolean isSongInFavourites(@NonNull String mediaId) {
        for (MediaMetadataCompat metadata :
                mPlaylistSongsByPlaylistKey.get(PlaylistsSource.FAVORITES_PLAYLIST_ID+"")) {
            if (mediaId.equals(metadata.getDescription().getMediaId())) {
                return true;
            }
        }
        return false;
    }

