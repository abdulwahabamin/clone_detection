    @Override
    protected void onStart() {
        super.onStart();
        try {
            connectToSession(mediaBrowser.getSessionToken());
        } catch (IllegalStateException | RemoteException e) {
            FireLog.e(TAG, "could not connect media controller");
        }
    }

