        @Override
        public void onSessionDestroyed() {
            super.onSessionDestroyed();
            FireLog.d(TAG, "Session was destroyed, resetting to the new session token");
            try {
                updateSessionToken();
            } catch (RemoteException e) {
                FireLog.e(TAG, "could not connect media controller", e);
            }
        }

