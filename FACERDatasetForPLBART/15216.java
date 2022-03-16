    /**
     * @param id
     * @return removes track from a playlist
     */
    public static int removeTrack(long id) {
        if (mService == null)
            return 0;

        try {
            return mService.removeTrack(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }

