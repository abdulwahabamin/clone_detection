    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() entry.");

        currentTrackPlayer = null;
        onDeckTrackPlayer = null;

        deferredPosition = -1;
        deferredGo = false;

        playingIndexInfo = null;
        onDeckIndexInfo = null;

        shuffleRand = new Random();
        shuffleSeed = shuffleRand.nextLong();
        lastShuffleSeed = shuffleSeed;
        rand = new Random();
        am = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
    }

