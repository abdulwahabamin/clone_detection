    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.d(TAG, "onError(what=" + what + ", extra=" + extra + ") entry.");
        resetToInitialState();
        return false;
    }

