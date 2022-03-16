    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() entry.");

        if (playIntent == null) {
            playIntent = new Intent(this, MusicService.class);
            bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
            startService(playIntent);
        }
    }

