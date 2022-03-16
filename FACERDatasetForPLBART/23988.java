        @Override
        public void handleMessage(Message msg) {
            // Check again to make sure nothing is playing right now
            if (isPlaying() || mPausedByTransientLossOfFocus || mServiceInUse) {
                return;
            }

            Log.d(TAG, "idle timeout, quitting");

            // save the queue again, because it might have changed
            // since the user exited the music app (because of
            // the play-position changed)
            saveQueue(true);
            stopSelf(mServiceStartId);
        }

