    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        AsyncGetSongList task=new AsyncGetSongList(mContext);
        task.setOnBuildLibraryProgressUpdate(this);
        task.setOnBuildLibraryProgressUpdate(new WelcomeActivity());
        task.execute();
        return START_STICKY;
    }

