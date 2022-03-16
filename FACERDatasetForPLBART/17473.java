    @Override
    public void addMusicMediaIdToPlaylist(long playlistId, String mediaId) {
        Playlist playlist = getPlaylistById(playlistId);
        if (playlist != null) {
            playlist.getMusicMediaIds().add(mediaId);
            putPlaylist(playlist);
        }
    }

