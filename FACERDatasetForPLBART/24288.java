    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((MediaPlaybackService.LocalBinder)binder).getService();

        playerHeaderFragment.onServiceConnected(service);
        playQueueFragment.onServiceConnected(service);
        playerFooterFragment.onServiceConnected(service);

        invalidateOptionsMenu();
        updateTrackInfo();

        // Assume something is playing when the service says it is,
        // but also if the audio ID is valid but the service is paused.
        if (this.service.getAudioId() >= 0 || this.service.isPlaying()) {
            // something is playing now, we're done
            return;
        }
        // Service is dead or not playing anything. If we got here as part
        // of a "play this file" Intent, exit. Otherwise go to the Music app start screen.
        if (getIntent().getData() == null) {
            Intent intent = new Intent(MediaPlaybackActivity.this, MusicBrowserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        finish();
    }

