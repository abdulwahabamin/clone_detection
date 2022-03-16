                @Override
                public void onConnected() {
                    FireLog.d(TAG, "MediaBrowser.ConnectionCallback.onConnected");
                    try {
                        connectToSession(mediaBrowser.getSessionToken());
                    } catch (RemoteException e) {
                        FireLog.e(TAG, "could not connect media controller", e);
                        hidePlaybackControls();
                    }
                }

