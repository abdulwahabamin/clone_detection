    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initMediaSessions() {
        mMediaPlayer = PlayBackUtil.getMediaPlayer();

        mSession = new MediaSessionCompat(getApplicationContext(), "simple player session");
        try {
            mController = new MediaControllerCompat(getApplicationContext(), mSession.getSessionToken());
        } catch (RemoteException e) {
            Timber.e(e, "initMediaSessions");
        }

        mSession.setCallback(
                new MediaSessionCompat.Callback() {
                    @Override
                    public void onPlay() {
                        super.onPlay();
                        mMediaPlayer.start();
                        buildNotification(generateAction(R.drawable.ic_pause_white_24dp, Constants.ACTION_PAUSE));
                    }

                    @Override
                    public void onPause() {
                        super.onPause();
                        mMediaPlayer.pause();
                        buildNotification(generateAction(R.drawable.ic_play_arrow_white_24dp, Constants.ACTION_PLAY));
                    }

                    @Override
                    public void onSkipToNext() {
                        super.onSkipToNext();
                        int lastIndex = songDTOs.size() - 1;
                        if (currentPosition == lastIndex) {
                            currentPosition = 0;
                            if (PlayBackUtil.getCurrentPlayMode() != PlayMode.ALL_REPEAT
                                    || PlayBackUtil.getCurrentPlayMode() != PlayMode.SHUFFLE_REPEAT) {
                                mMediaPlayer.stop();
                                buildNotification(generateAction(R.drawable.ic_play_arrow_white_24dp, Constants.ACTION_PLAY));
                                PlayBackUtil.setCurrentSongPosition(currentPosition);
                                return;
                            }
                        } else {
                            currentPosition++;
                        }
                        reInitialiseMediaSession(currentPosition);

                        rhythmSong = MusicDataUtility.getSongMeta(songDTOs.get(currentPosition).getSongLocation());

                        buildNotification(generateAction(R.drawable.ic_pause_white_24dp, Constants.ACTION_PAUSE));

                        Intent nextIntent = new Intent(Constants.PLAYER);
                        nextIntent.putExtra("player_command", "next");
                        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(nextIntent);
                    }

                    @Override
                    public void onSkipToPrevious() {
                        super.onSkipToPrevious();
                        //Change media here
                        if (currentPosition == 0) {
                            currentPosition = songDTOs.size() - 1;
                        } else {
                            currentPosition--;
                        }
                        reInitialiseMediaSession(currentPosition);

                        rhythmSong = MusicDataUtility.getSongMeta(songDTOs.get(currentPosition).getSongLocation());

                        buildNotification(generateAction(R.drawable.ic_pause_white_24dp, Constants.ACTION_PAUSE));

                        Intent previousIntent = new Intent(Constants.PLAYER);
                        previousIntent.putExtra("player_command", "previous");
                        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(previousIntent);
                    }

                    @Override
                    public void onStop() {
                        super.onStop();
                        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.cancel(NOTIFICATION_ID);
                        Intent intent = new Intent(getApplicationContext(), MediaPlayerService.class);
                        mMediaPlayer.pause();
                        stopService(intent);
                    }
                }
        );
    }

