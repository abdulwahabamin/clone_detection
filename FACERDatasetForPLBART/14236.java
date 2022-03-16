    /**
     * @param mContext
     * @param list
     */
    public static void addToCurrentPlaylist(Context mContext, long[] list) {

        if (mService == null)
            return;
        try {
            mService.enqueue(list, ApolloService.LAST);
            String message = mContext.getResources().getQuantityString(
                    R.plurals.NNNtrackstoplaylist, list.length, Integer.valueOf(list.length));
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
        } catch (RemoteException ex) {
        }
    }

