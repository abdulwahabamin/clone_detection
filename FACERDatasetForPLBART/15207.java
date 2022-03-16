    /**
     * @return current artist ID
     */
    public static long getCurrentArtistId() {

        if (MusicUtils.mService != null) {
            try {
                return mService.getArtistId();
            } catch (RemoteException ex) {
            }
        }
        return -1;
    }

