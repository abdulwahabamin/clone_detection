    public static SongsFragment newInstance(Cursor songCursor,
                                            SongAdapter.SongClickListener songClickListener) {
        SongsFragment fragment = new SongsFragment();
        fragment.songAdapter = new SongAdapter(songCursor,
                songClickListener);

        return fragment;
    }

