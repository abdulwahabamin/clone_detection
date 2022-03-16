        @Override
        public void onException(Exception cause) {
            Log.w(TAG, "Got exception while reading data", cause);
            closeWithError("Got exception while reading data: " + cause.getMessage());
            if (mSignal != null) {
                mSignal.cancel();
            }
        }

