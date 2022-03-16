    @Override
    protected void onHandleIntent(final Intent intent) {
        File file = new File(Library.DATABASE_LOCATION, Library.LOCAL_DATABASE_NAME);
        if(file.exists()) {
            file.delete();
        }

        Library.initialize(this);

        File lastQueue = new File(PlayerService.PLAY_QUEUE_FILE_PATH);

        if(lastQueue.exists()) {
            try {
                Global.playQueue = new PlayQueue(lastQueue);
            } catch (IOException e) {
                Global.playQueue = null;
                lastQueue.delete();
            }
        }

        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(
                new Intent(SplashActivity.LIBRARY_INITIALIZED_ACTION));
    }

