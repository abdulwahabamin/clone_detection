    /**
     * @return current track's queue position
     */
    public static int getQueuePosition() {
        if (mService == null)
            return 0;
        try {
            return mService.getQueuePosition();
        } catch (RemoteException e) {
        }
        return 0;
    }

