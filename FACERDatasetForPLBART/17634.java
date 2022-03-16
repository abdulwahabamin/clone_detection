    @Override
    public void onStart() {
        Log.d(TAG, "onStart:called");

        mIconPath =  mMediaItem.getDescription().getIconUri() != null
                ? mMediaItem.getDescription().getIconUri().getEncodedPath()
                : null;
    }

