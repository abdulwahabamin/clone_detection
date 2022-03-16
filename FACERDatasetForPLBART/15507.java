    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View root = inflater.inflate(R.layout.nowplaying_album_art, null);
        albumArt = (ImageView)root.findViewById(R.id.audio_player_album_art);
        return root;
    }

