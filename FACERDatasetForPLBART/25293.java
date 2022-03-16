    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initMediaSessions();

        handleIntent(intent);
        return super.onStartCommand(intent, flags, startId);
    }

