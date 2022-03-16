        @Override
        public void onPlaybackStateChanged(@NonNull PlaybackStateCompat state) {
            PlaybackStateCompat oldState = mPlaybackState;
            mPlaybackState = state;

            Log.d(TAG, "Received new playback state"+ state);

            if (mPlaybackState.getState() == PlaybackStateCompat.STATE_STOPPED ||
                    mPlaybackState.getState() == PlaybackStateCompat.STATE_NONE) {
                stopNotification();
            } else {
                Notification notification = createNotification();
                if (notification != null) {
                    if (mPlaybackState.getState() == PlaybackStateCompat.STATE_PLAYING) {
                        if (mPlaybackState.getState() != oldState.getState()) {
                            // if the state changed from stopped to playing then
                            // start foreground so as to maintain service running even after
                            // app swiped away in recent apps
                            mService.startForeground(NOTIFICATION_ID, notification);
                        } else {
                            // if it has not changed from stopped to playing
                            // then notification already running in foreground
                            mNotificationManager.notify(NOTIFICATION_ID, notification);
                        }
                    } else if (mPlaybackState.getState() == PlaybackStateCompat.STATE_PAUSED) {
                        // if it has changed to paused then stopForeground()
                        // was called in the service in method onPlaybackStopped()
                        mNotificationManager.notify(NOTIFICATION_ID, notification);
                    }

                }
            }

        }

