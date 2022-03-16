    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().size() > 0) {
            song = getArguments().getParcelable(SONG_PARAM);
            songPosition = getArguments().getInt(SONG_POSITION_PARAM);
            rhythmSong = MusicDataUtility.getSongMeta(song.getSongLocation());
        }
        handler = new Handler();
    }

