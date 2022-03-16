    /**
     * @return current track name
     */
    public static String getTrackName() {

        if (mService != null) {
            try {
                return mService.getTrackName();
            } catch (RemoteException ex) {
            }
        }
        return null;
    }

