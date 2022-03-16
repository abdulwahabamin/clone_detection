        /**
         * Builds the cursor query's selection clause based on the activity's
         * current usage case.
         */
        private String buildQuerySelectionClause() {
            switch (mFragmentId) {
                case Common.ARTISTS_FLIPPED_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ARTIST + "=";
                    break;
                case Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ALBUM_ARTIST + "=";
                    break;
                case Common.ALBUMS_FLIPPED_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ALBUM + "=";
                case Common.GENRES_FLIPPED_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_GENRE + "=";
                    break;
            }

            mQuerySelection += "'" + mHeaderText.replace("'", "''") + "'";
            return mQuerySelection;
        }

