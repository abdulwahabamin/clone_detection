    public static SongFragment newInstance(SongDTO song, int position) {
        SongFragment fragment = new SongFragment();
        Bundle args = new Bundle();
        args.putParcelable(SONG_PARAM, song);
        args.putInt(SONG_POSITION_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

