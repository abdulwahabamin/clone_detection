    /**
     * Prepares exoplayer for audio playback from a local file
     *
     * @param music
     */
    private void prepareExoPlayerFromFileUri(final Music music) {
        setUpExoPlayer(new DefaultTrackSelector(), new DefaultLoadControl());
        uriMediaSource = new DynamicConcatenatingMediaSource();
        playlist = new HashMap<>();
        addMediaSource(music);
        exoPlayer.prepare(uriMediaSource);
        exoPlayer.setPlayWhenReady(true);
        LinearLayout play_control = simpleExoPlayerView.findViewById(R.id.fullScreen);
        play_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFullScreenPlayer();
            }
        });
        exoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (getCurrentMusic() != null) {
                    Music currentMusic = getCurrentMusic();
                    final String name = currentMusic.getName();
                    final Uri uri = currentMusic.getUri();
                    TextView musicTitle = simpleExoPlayerView.findViewById(R.id.exo_title);
                    musicTitle.setText(name);
                    musicTitle.setSelected(true);
                    ImageButton download = simpleExoPlayerView.findViewById(R.id.exo_download);
                    download.setVisibility(View.GONE);
                    ImageButton share = simpleExoPlayerView.findViewById(R.id.exo_share);
                    share.setVisibility(View.VISIBLE);
                    share.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            shareFile(uri, name);
                        }
                    });
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity() {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }
        });
    }

