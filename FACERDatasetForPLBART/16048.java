    public static SongsFragment newInstance(ArrayList<Song> songList,
                                            SongAdapter.SongQueueClickListener songQueueClickListener) {
        SongsFragment fragment = new SongsFragment();
        fragment.songAdapter = new SongAdapter(songList, songQueueClickListener);

        return fragment;
    }

