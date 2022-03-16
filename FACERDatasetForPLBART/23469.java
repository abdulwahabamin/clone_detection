    public void init() {
        setContentView(R.layout.music_library);
        mNowPlayingView = findViewById(R.id.nowplaying);
        mTitle = (TextView) mNowPlayingView.findViewById(R.id.title);
        mArtist = (TextView) mNowPlayingView.findViewById(R.id.artist);
        
        View b = (View) findViewById(R.id.browse_button); 
        b.setOnClickListener(this);
        
        b = (View) findViewById(R.id.albums_button);
        b.setOnClickListener(this);

        b = (View) findViewById(R.id.tracks_button);
        b.setOnClickListener(this);

        b = (View) findViewById(R.id.playlists_button);
        b.setOnClickListener(this);
    }

