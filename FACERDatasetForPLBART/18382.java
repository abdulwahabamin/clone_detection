        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int index, long id) {
            int playbackRouteId = Common.PLAY_ALL_SONGS;
            switch (mFragmentId) {
                case Common.ARTISTS_FLIPPED_SONGS_FRAGMENT:
                case Common.ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT:
                case Common.GENRES_FLIPPED_FRAGMENT:
                case Common.ALBUMS_FLIPPED_FRAGMENT:
                    playbackRouteId = Common.PLAY_ALL_BY_ALBUM;
                    break;
            }

            mApp.getPlaybackKickstarter()
                .initPlayback(mContext,
                        mQuerySelection,
                        playbackRouteId,
                        index,
                        true,
                        false);

        }

