    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        currentLength = 0;
        currentLengthLowPassed = 0;
        lastUpdate = 0;
        gravity[0] = 0;
        gravity[1] = 0;
        gravity[2] = 0;
        return super.onStartCommand(intent, flags, startId);
    }

