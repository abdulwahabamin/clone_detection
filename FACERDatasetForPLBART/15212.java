    /**
     * @return duration of a track
     */
    public static long getDuration() {
        if (mService != null) {
            try {
                return mService.duration();
            } catch (RemoteException e) {
            }
        }
        return 0;
    }

