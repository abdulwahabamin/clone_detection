        public void onServiceConnected(ComponentName className, android.os.IBinder service) {
            sService = ((MediaPlaybackService.LocalBinder)service).getService();
            if (mCallback != null) {
                mCallback.onServiceConnected(className, service);
            }
        }

