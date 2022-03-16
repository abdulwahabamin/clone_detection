    public static void seek(final long position) {
        if (mService != null) {
            try {
                mService.seek(position);
            } catch (final RemoteException ignored) {
            } catch (IllegalStateException ignored) {

            }
        }
    }

