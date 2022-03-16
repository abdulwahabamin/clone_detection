    private void onPreferencesUpdate(Bundle extras) {
        mShowAlbumArtOnLockscreen = extras.getBoolean("lockscreen", mShowAlbumArtOnLockscreen);
        mActivateXTrackSelector = extras.getBoolean("xtrack", mActivateXTrackSelector);
        LastfmUserSession session = LastfmUserSession.getSession(this);
        session.mToken = extras.getString("lf_token", session.mToken);
        session.mUsername = extras.getString("lf_user", session.mUsername);
        if ("logout".equals(session.mToken)) {
            session.mToken = null;
            session.mUsername = null;
        }
        notifyChange(META_CHANGED);

    }

