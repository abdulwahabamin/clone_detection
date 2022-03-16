    @Override
    public void onFavoriteStatusChange(String mediaId, boolean status) {
        mPlaybackManager.updatePlaybackState(null);
//        Bundle b = new Bundle();
//        b.putString(KEY_MEDIA_ID, mediaId);
//        b.putBoolean(KEY_FAV_STATUS, status);
//        mMediaSession.sendSessionEvent(SESSION_FAVORITE_EVENT, b);
    }

