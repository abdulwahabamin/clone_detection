    /**
     * @param index
     */
    public static void setQueuePosition(int index) {
        if (mService == null)
            return;
        try {
            mService.setQueuePosition(index);
        } catch (RemoteException e) {
        }
    }

