        @Override
        public void handleMessage(Message msg) {
            MusicPlayerService service = mWeakReference.get();
            if (service != null && service.playbackManager.getPlayback() != null) {
                if (service.playbackManager.getPlayback().isPlaying()) {
                    FireLog.d(TAG, "Ignoring delayed stop since the media player is in use.");
                    return;
                }
                FireLog.d(TAG, "Stopping service with delay handler.");
                service.stopSelf();
            }
        }

