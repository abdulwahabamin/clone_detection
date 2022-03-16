    private long[] fetchSongList(long playlistId) {
        return MusicUtils.getSongListForCursorAndClose(MusicUtils.query(getActivity(),
                MusicContract.Playlist.getMembersUri(playlistId),
                null,
                null,
                null,
                null));
    }

