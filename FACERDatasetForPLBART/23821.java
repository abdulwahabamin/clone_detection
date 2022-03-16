    @Override
    public int getCurrentPosition() {
        // Log.d(TAG, "getCurrentPosition() Entry.");
        if (musicSrv != null)
            return musicSrv.getPosition();
        return 0;

    }

