    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        } catch (Exception e) {
            // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.player);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
        btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);
        imageView = (ImageView) findViewById(R.id.imageView);
        songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
        songArtistLabel = (TextView) findViewById(R.id.songArtist);
        songTitleLabel = (TextView) findViewById(R.id.songTitle);
        songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
        songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);
        ImageButton btnAbout = (ImageButton) findViewById(R.id.about);
        ImageButton btnForward = (ImageButton) findViewById(R.id.btnForward);
        ImageButton btnBackward = (ImageButton) findViewById(R.id.btnBackward);
        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext);
        ImageButton btnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
        ImageButton btnPlaylist = (ImageButton) findViewById(R.id.btnPlaylist);

        // am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 2, 0);
        if (am.getStreamVolume(AudioManager.STREAM_MUSIC) == 0) {
            am.setStreamVolume(AudioManager.STREAM_MUSIC, 1, 0);
        }

        mp = new MediaPlayer();
        utils = new Utilities();

        songProgressBar.setOnSeekBarChangeListener(this);
        mp.setOnCompletionListener(this);

        SongsManager songManager = new SongsManager();
        if (!(songManager.getPlayList() == null)) {
            songsList = songManager.getPlayList();
        }

        // By default play first song if bluetooth headphone is enabled
        if (songsList == null) {
            Toast.makeText(getApplicationContext(), getString(R.string.songlist_null), Toast.LENGTH_SHORT).show();
        } else if (songsList.size() > 0) {
            if (isBTEnabled()) {
                playSong(0);
            }
        }

        btnAbout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showAbout();
            }
        });

        /**
         * Play button click event
         * plays a song and changes button to pause image
         * pauses a song and changes button to play image
         * */
        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check for already playing
                // Resume song
                playpause();
            }
        });

        /**
         * Forward button click event
         * Forwards song specified seconds
         * */
        btnForward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                forward();
            }
        });

        /**
         * Backward button click event
         * Backward song to specified seconds
         * */
        btnBackward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                backward();
            }
        });

        /**
         * Next button click event
         * Plays next song by taking currentSongIndex + 1
         * */
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                next();
            }
        });

        /**
         * Back button click event
         * Plays previous song by currentSongIndex - 1
         * */
        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                previous();
            }
        });

        /**
         * Button Click event for Repeat button
         * Enables repeat flag to true
         * */
        btnRepeat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    if (isRepeat) {
                        isRepeat = false;
                        Toast.makeText(getApplicationContext(), "Repeat is OFF", Toast.LENGTH_SHORT).show();
                        btnRepeat.setImageResource(R.drawable.btn_repeat);
                    } else {
                        isRepeat = true;
                        Toast.makeText(getApplicationContext(), "Repeat is ON", Toast.LENGTH_SHORT).show();
                        isShuffle = false;
                        btnRepeat.setImageResource(R.drawable.btn_repeat_focused);
                        btnShuffle.setImageResource(R.drawable.btn_shuffle);
                    }
                } catch (Exception e) {
                    // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Button Click event for Shuffle button
         * Enables shuffle flag to true
         * */
        btnShuffle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    if (isShuffle) {
                        isShuffle = false;
                        Toast.makeText(getApplicationContext(), "Shuffle is OFF", Toast.LENGTH_SHORT).show();
                        btnShuffle.setImageResource(R.drawable.btn_shuffle);
                    } else {
                        isShuffle = true;
                        Toast.makeText(getApplicationContext(), "Shuffle is ON", Toast.LENGTH_SHORT).show();
                        isRepeat = false;
                        btnShuffle.setImageResource(R.drawable.btn_shuffle_focused);
                        btnRepeat.setImageResource(R.drawable.btn_repeat);
                    }
                } catch (Exception e) {
                    // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Button Click event for Play list click event
         * Launches list activity which displays list of songs
         * */
        btnPlaylist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showPlayList();
            }
        });
    }

