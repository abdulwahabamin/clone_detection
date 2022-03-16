    private void setFullScreenPlayer() {
        final Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.setContentView(R.layout.dialog_fullscreen_player);
        Toolbar toolbar = dialog.findViewById(R.id.dialog_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        ListView listView = dialog.findViewById(R.id.listView);
        List<Music> list = new ArrayList<Music>(playlist.values());
        PlaylistItemAdapter dataAdapter = new PlaylistItemAdapter(this, R.layout.playlist_song_item, list);
        listView.setAdapter(dataAdapter);
        dataAdapter.setCallback(this);
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
                    AppCompatTextView musicTitle = dialog.findViewById(R.id.exo_title);
                    musicTitle.setText(name);
                    musicTitle.setSelected(true);
                    ImageButton share = dialog.findViewById(R.id.exo_share);
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

        exoPlayer.setPlayWhenReady(false);
        SimpleExoPlayerView simplePlayerView = dialog.findViewById(R.id.fullscreen_view);
        simplePlayerView.setPlayer(exoPlayer);
        exoPlayer.setPlayWhenReady(true);
        dialog.show();
    }

