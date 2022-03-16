    @Override
    protected void additionalCreate() {
        Intent intent = new Intent(this, PlaybackActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mSession.setSessionActivity(pendingIntent);

        mSession.setCallback(new MediaSession.Callback() {
            @Override
            public void onPlay() {
                play();
            }

            @Override
            public void onPause() {
                pause();
            }

            @Override
            public void onStop() {
                pause();
                seek(0);
            }

            @Override
            public void onSkipToPrevious() {
                previousOrRestartCurrent();
            }

            @Override
            public void onSkipToNext() {
                next();
            }
        });
    }

