                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        // mediaController.getTransportControls().pause();
                        pausePlayer();
                        // Wait 30 seconds before stopping playback
/*
                        mHandler.postDelayed((Runnable) () -> currentTrackPlayer.stop(),
                                TimeUnit.SECONDS.toMillis(30));
*/
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback
                        pausePlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lower the volume, keep playing
                        if (currentTrackPlayer != null)
                            currentTrackPlayer.setVolume(0.25f, 0.25f);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        if (currentTrackPlayer != null)
                            currentTrackPlayer.setVolume(1.0f, 1.0f);
                    }
                }

