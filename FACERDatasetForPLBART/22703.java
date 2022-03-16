        @Override
        public void onPlayFromMediaId(final String mediaId, Bundle extras) {
            long songId = Long.parseLong(mediaId);
            setSessionActive();
            MusicPlayer.playAll(mContext, new long[]{songId}, 0, -1, TimberUtils.IdType.NA, false);
        }

