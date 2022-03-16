    @Override
    public void removeMusicMediaIdFromPlaylist(long playlistId, String mediaId) {
        Playlist playlist = getPlaylistById(playlistId);
        if (playlist != null) {
            playlist.getMusicMediaIds().remove(playlist.getMusicMediaIds().indexOf(mediaId));
            putPlaylist(playlist);
        }
    }

