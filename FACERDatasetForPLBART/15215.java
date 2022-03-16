    /**
     * Method that removes all tracks from the current queue
     */
    public static void removeAllTracks() {
        try {
            if (mService == null) {
                long[] current = MusicUtils.getQueue();
                if (current != null) {
                    mService.removeTracks(0, current.length-1);
                }
            }
        } catch (RemoteException e) {
        }
    }

