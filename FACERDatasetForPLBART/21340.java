        @Override
        public void onSessionStarted(Session session, String sessionId) {
            invalidateOptionsMenu();
            mCastSession = mSessionManager.getCurrentCastSession();
            showCastMiniController();
        }

