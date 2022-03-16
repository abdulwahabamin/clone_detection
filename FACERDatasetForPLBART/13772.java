    /**
     * Prepares exoplayer for audio playback from a remote URL audiofile. Should work with most
     * popular audiofile types (.mp3, .m4a,...)
     *
     * @param url Provide a Url in a form of http://blabla.bleble.com/blublu.mp3)
     */
    private void prepareExoPlayerFromURL(final String url, final String name) {
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        setUpExoPlayer(trackSelector, new DefaultLoadControl());
        ImageButton play = simpleExoPlayerView.findViewById(R.id.exo_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicConcatenatingMediaSource mediaSource = new DynamicConcatenatingMediaSource();
                mediaSource.addMediaSource(getMediaSourceFromURL(url));
                exoPlayer.prepare(mediaSource);
                exoPlayer.setPlayWhenReady(true);
            }
        });

        TextView musicTitle = simpleExoPlayerView.findViewById(R.id.exo_title);
        musicTitle.setText(name);
        musicTitle.setSelected(true);
        ImageButton share = simpleExoPlayerView.findViewById(R.id.exo_share);
        share.setVisibility(View.GONE);
        ImageButton download = simpleExoPlayerView.findViewById(R.id.exo_download);
        download.setVisibility(View.VISIBLE);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideoAd();
                DownloadFile.download(HomeScreenActivity.this, url, name);
            }
        });
    }

