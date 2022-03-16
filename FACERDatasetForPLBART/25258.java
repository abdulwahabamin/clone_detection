    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_song, container, false);
        beenDrawn = true;
        track = (TextView) rootView.findViewById(R.id.txt_track);
        txtDuration = (TextView) rootView.findViewById(R.id.txt_duration);
        playButton = (ImageView) rootView.findViewById(R.id.play_button);

        trackProgress = (CircularSeekBar) rootView.findViewById(R.id.track_progress);
        trackProgress.setMax(100);

        trackProgress.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                if (mediaPlayer != null) {
                    float currentDuration = (((float) circularSeekBar.getProgress() / 100) * mediaPlayer.getDuration());
                    updateDuration(milliSecondsToTimer((long) currentDuration), TimeFormatUtils.secondsToTimer(mediaPlayer.getDuration() / 1000));
                }
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                mediaPlayer.start();
                startTimer();
                int currentMill = (int) (((float) seekBar.getProgress() / 100) * mediaPlayer.getDuration());
                mediaPlayer.seekTo(currentMill);
                playButton.setImageResource(R.drawable.ic_pause_white_24dp);
            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {
                stopTimer();
            }
        });

        albumCover = (CircleImageView) rootView.findViewById(R.id.album_cover);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    playButton.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                    mediaPlayer.pause();
                    stopTimer();
                    playerNotification(Constants.ACTION_PAUSE);
                } else {
                    playButton.setImageResource(R.drawable.ic_pause_white_24dp);
                    CustomAnimUtil.overShootAnimation(albumCover);
                    mediaPlayer.start();
                    startTimer();
                    playerNotification(Constants.ACTION_PLAY);
                }
            }
        });
        removePlayerListeners();
        setPlayerListeners();
        if (mediaPlayer != null && mediaPlayer.isPlaying() && rhythmSong.getSongLocation().equals(PlayBackUtil.getCurrentSong().getSongLocation())) {
            startTimer();
        }

        updatePlayerUI();
        return rootView;
    }

