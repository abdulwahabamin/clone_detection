    public int onStartCommand(Intent intent, int flags, int startId) {
        switch (intent.getAction()) {
            case ACTION_PLAY_TEST:
                release();
                mMediaPlayer = MediaPlayer.create(this, R.raw.flowers_of_scotland);
                mMediaPlayer.setOnPreparedListener(this);
                break;
            case ACTION_PLAY_DIRECTORY:
                filesQueue.clear();
                queueDirectory(intent.getStringExtra("directory"));
                if (filesQueue.size() != 0) {
                    playQueue();
                }
                break;
            case ACTION_PAUSE:
                if (mMediaPlayer != null) {
                    mMediaPlayer.pause();
                }
                break;
            case ACTION_RESUME:
                if (mMediaPlayer != null) {
                    mMediaPlayer.start();
                }
                break;
            case ACTION_PREVIOUS:
                if (mMediaPlayer != null) {
                    previous();
                }
                break;
            case ACTION_NEXT:
                if (mMediaPlayer != null) {
                    next();
                }
                break;
        }
        return START_NOT_STICKY;
    }

