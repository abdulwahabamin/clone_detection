    /**
     * @return current artist name
     */
    public static String getArtistName() {

        if (mService != null) {
            try {
                return mService.getArtistName();
            } catch (RemoteException ex) {
            }
        }
        return null;
    }

