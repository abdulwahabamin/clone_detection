                @Override
                public void onConnectionSuspended() {
                    // The Service has crashed. Disable transport controls
                    // until it automatically reconnects
                    mMediaBrowserCallback.onMediaBrowserConnectionSuspended();
                }

