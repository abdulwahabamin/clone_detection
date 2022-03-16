    /**
     * @return current track ID
     */
    public static long getCurrentAudioId() {

        if (MusicUtils.mService != null) {
            try {
                return mService.getAudioId();
            } catch (RemoteException ex) {
            }
        }
        return -1;
    }

