    /**
     * @return
     */
    public static long[] getQueue() {

        if (mService == null)
            return sEmptyList;

        try {
            return mService.getQueue();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return sEmptyList;
    }

