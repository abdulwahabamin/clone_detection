    /**
     * Toggle favorites
     */
    public static void toggleFavorite() {

        if (mService == null)
            return;
        try {
            mService.toggleFavorite();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

