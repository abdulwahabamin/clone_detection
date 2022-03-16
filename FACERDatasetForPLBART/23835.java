    private void setupDisplay(PlayInfo playInfo) {
        setContentView(R.layout.main_activity);
        initToolBar();

        genreSpinner = findViewById(R.id.genre_select);
        albumSpinner = findViewById(R.id.album_select);
        songView = findViewById(R.id.song_list);

        mSeekBar = findViewById(R.id.seekTo);
        initializeSeekBar();

        mPlayPauseButton = findViewById(R.id.play_pause);

        mPlayingAlbum = findViewById(R.id.playing_album);
        mPlayingSong = findViewById(R.id.playing_song);
        mPlayingArtist = findViewById(R.id.playing_artist);
        mDuration = findViewById(R.id.duration);
        mSongPosition = findViewById(R.id.song_position);
        mPlayingArtwork = findViewById(R.id.cover_art);
        mPlayingSongId = -1;

        songAdt = new SongAdapter(this, currentDisplayPlayList);
        songView.setAdapter(songAdt);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            setupGenreList(playInfo);
        } else {
            Log.d(TAG, "onCreate(): Need permission to access storage.");
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_STORAGE);
        }
    }

