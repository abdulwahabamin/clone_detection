        /**
         * Populates the DB column names based on the specifed fragment id.
         */
        private void loadDBColumnNames() {

            switch (mFragmentId) {
                case Common.ARTISTS_FLIPPED_SONGS_FRAGMENT:
                case Common.ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT:
                case Common.ALBUMS_FLIPPED_FRAGMENT:
                case Common.GENRES_FLIPPED_SONGS_FRAGMENT:
                    mDBColumnsMap.put(ListViewCardsAdapter.TITLE_TEXT, DBAccessHelper.SONG_TITLE);
                    mDBColumnsMap.put(ListViewCardsAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
                    mDBColumnsMap.put(ListViewCardsAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
                    mDBColumnsMap.put(ListViewCardsAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                    mDBColumnsMap.put(ListViewCardsAdapter.FIELD_1, DBAccessHelper.SONG_DURATION);
                    mDBColumnsMap.put(ListViewCardsAdapter.FIELD_2, DBAccessHelper.SONG_ARTIST);
                    mDBColumnsMap.put(ListViewCardsAdapter.FIELD_3, DBAccessHelper.SONG_TRACK_NUMBER);
                    break;
            }

        }

