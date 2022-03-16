        /**
         * Builds the cursor query's selection clause based on the activity's
         * current usage case.
         */
        private String buildQuerySelectionClause() {
            switch (mFragmentId) {
                case Common.ARTISTS_FLIPPED_SONGS_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ALBUM + "=" + "'"
                                    + mHeaderText.replace("'", "''") + "'" + " AND "
                                    + DBAccessHelper.SONG_ARTIST + "=" + "'"
                                    + mHeaderSubText.replace("'", "''") + "'";
                    break;
                case Common.ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ALBUM + "=" + "'"
                                    + mHeaderText.replace("'", "''") + "'" + " AND "
                                    + DBAccessHelper.SONG_ALBUM_ARTIST + "=" + "'"
                                    + mHeaderSubText.replace("'", "''") + "'";
                    break;
                case Common.ALBUMS_FLIPPED_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ALBUM + "=" + "'"
                                    + mHeaderText.replace("'", "''") + "'" + " AND "
                                    + DBAccessHelper.SONG_ARTIST + "=" + "'"
                                    + mHeaderSubText.replace("'", "''") + "'";
                    break;
                case Common.GENRES_FLIPPED_SONGS_FRAGMENT:
                    mQuerySelection = " AND " + DBAccessHelper.SONG_ALBUM + "=" + "'"
                                    + mHeaderText.replace("'", "''") + "'" + " AND "
                                    + DBAccessHelper.SONG_GENRE + "=" + "'"
                                    + mHeaderSubText.replace("'", "''") + "'" + " AND "
                                    + DBAccessHelper.SONG_ARTIST + "=" + "'"
                                    + mField2.replace("'", "''") + "'";
                    break;
            }

            return mQuerySelection;
        }

