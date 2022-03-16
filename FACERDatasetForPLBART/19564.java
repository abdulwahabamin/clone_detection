        @Override
        public void onServiceCursorFailed(String exceptionMessage) {
            //We don't have a valid cursor, so stop the service.
            Log.e("SERVICE CURSOR EXCEPTION", "onServiceCursorFailed(): " + exceptionMessage);
            Toast.makeText(mContext, R.string.unable_to_start_playback, Toast.LENGTH_SHORT).show();
            stopSelf();

        }

