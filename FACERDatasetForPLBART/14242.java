    /**
     * @return current album name
     */
    public static String getAlbumName() {

        if (mService != null) {
            try {
                return mService.getAlbumName();
            } catch (RemoteException ex) {
            }
        }
        return null;
    }

