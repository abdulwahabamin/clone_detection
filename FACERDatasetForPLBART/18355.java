        /**
         * Populates the DB column names based on the specifed fragment id.
         */
        private void loadDBColumnNames() {

            switch (mFragmentId) {
                case Common.ARTISTS_FLIPPED_FRAGMENT:
                    mDBColumnsMap.put(BrowserSubGridAdapter.TITLE_TEXT, DBAccessHelper.SONG_ALBUM);
                    mDBColumnsMap.put(BrowserSubGridAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
                    mDBColumnsMap.put(BrowserSubGridAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FIELD_1, DBAccessHelper.SONGS_COUNT);
                    break;
                case Common.ALBUM_ARTISTS_FLIPPED_FRAGMENT:
                    mDBColumnsMap.put(BrowserSubGridAdapter.TITLE_TEXT, DBAccessHelper.SONG_ALBUM);
                    mDBColumnsMap.put(BrowserSubGridAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
                    mDBColumnsMap.put(BrowserSubGridAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FIELD_1, DBAccessHelper.SONGS_COUNT);
                case Common.GENRES_FLIPPED_FRAGMENT:
                    mDBColumnsMap.put(BrowserSubGridAdapter.TITLE_TEXT, DBAccessHelper.SONG_ALBUM);
                    mDBColumnsMap.put(BrowserSubGridAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
                    mDBColumnsMap.put(BrowserSubGridAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FIELD_1, DBAccessHelper.SONG_ARTIST);
                    mDBColumnsMap.put(BrowserSubGridAdapter.FIELD_2, DBAccessHelper.SONG_ARTIST); //Used by GenresFlippedSongs.
                    break;
            }

        }

