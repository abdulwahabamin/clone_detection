        @Override
        public void onSessionEnded(Session session, int error) {
            mCastSession = null;
            hideCastMiniController();
            stopCastServer();
        }

