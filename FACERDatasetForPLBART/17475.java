    @Override
    public void deletePlaylist(long id) {
        List<String> playlistIds = getPlaylistIds();
        if (playlistIds != null) {
            int index = playlistIds.indexOf(id+"");
            if (index>0) {
                playlistIds.remove(index);
                putPlaylistIds(playlistIds);
            }
        }
    }

