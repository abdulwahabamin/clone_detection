                @Override
                public void onPlaybackStateChanged(@NonNull PlaybackStateCompat state) {
                    FireLog.d(TAG, "(++) onPlaybackStateChanged");
                    if (shouldShowControls()) {
                        showPlaybackControls();
                    } else {
                        FireLog.d(TAG, "mediaControllerCallback.onPlaybackStateChanged: " +
                                "hiding controls because state is " + state.getState());
                        hidePlaybackControls();
                    }
                }

