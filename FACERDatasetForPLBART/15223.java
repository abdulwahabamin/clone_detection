    /**
     * @return if music is playing
     */
    public static boolean isPlaying() {
        if (mService == null)
            return false;

        try {
            return mService.isPlaying();
        } catch (RemoteException e) {
        }
        return false;
    }

