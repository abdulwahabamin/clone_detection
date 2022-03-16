    public static void clearQueue() {
        if (mService != null) {
            try {
                mService.removeTracks(0, Integer.MAX_VALUE);
            } catch (final RemoteException ignored) {
            }
        }
    }

