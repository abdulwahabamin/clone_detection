    @Override
    public void addNewPlaylist(Playlist playlist) {
        List<String> playlistIds = getPlaylistIds();
        if (playlistIds != null) {
            playlistIds.add(playlist.getId()+"");
            putPlaylistIds(playlistIds);
            putPlaylist(playlist);
        }
    }

