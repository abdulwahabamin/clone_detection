                @Override
                public void onConnected() {
                    // Get the token for the MediaSession
                    MediaSessionCompat.Token token = mMediaBrowser.getSessionToken();

                    if (MediaControllerCompat.getMediaController(mActivity) == null) {
                        Log.i(TAG, "onConnected:creating new media controller parent="+mParentName);
                        // Create a MediaControllerCompat
                        MediaControllerCompat mediaController;
                        try {
                            mediaController = new MediaControllerCompat(mActivity, // Context
                                    token);

                            if (mMediaControllerCallback != null) {
                                Log.d(TAG, "onConnected:mediaControllerCallback:registering parent="
                                        +mParentName);
                                mediaController.registerCallback(mMediaControllerCallback);
                            } else {
                                Log.w(TAG, "onConnected:mediaControllerCallback is null, not registering parent="+mParentName);
                            }

                            // Save the controller
                            MediaControllerCompat
                                    .setMediaController(mActivity, mediaController);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            Log.e(TAG, "onConnected:exception during getting media controller", e);
                        }
                    } else {
                        if (mMediaControllerCallback != null) {
                            Log.d(TAG, "onConnected:mediaControllerCallback:registering parent="+mParentName);
                            MediaControllerCompat
                                    .getMediaController(mActivity)
                                    .registerCallback(mMediaControllerCallback);
                        } else {
                            Log.w(TAG, "onConnected:mediaControllerCallback is null, not registering parent="+mParentName);
                        }
                    }

                    Log.i(TAG, "mediaBrowserConnected parent="+mParentName);

                    mMediaBrowserCallback.onMediaBrowserConnected();
                    subscribeMediaBrowser();
                }

