		/**
		 * Populates the DB column names based on the specifed fragment id.
		 */
		private void loadDBColumnNames() {
			
			switch (mFragmentId) {
			case Common.ARTISTS_FRAGMENT:
				mDBColumnsMap.put(GridViewCardsAdapter.TITLE_TEXT, DBAccessHelper.SONG_ARTIST);
				mDBColumnsMap.put(GridViewCardsAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
				mDBColumnsMap.put(GridViewCardsAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
				mDBColumnsMap.put(GridViewCardsAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                mDBColumnsMap.put(GridViewCardsAdapter.FIELD_1, DBAccessHelper.ALBUMS_COUNT);
				break;
			case Common.ALBUM_ARTISTS_FRAGMENT:
				mDBColumnsMap.put(GridViewCardsAdapter.TITLE_TEXT, DBAccessHelper.SONG_ALBUM_ARTIST);
				mDBColumnsMap.put(GridViewCardsAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
				mDBColumnsMap.put(GridViewCardsAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
				mDBColumnsMap.put(GridViewCardsAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                mDBColumnsMap.put(GridViewCardsAdapter.FIELD_1, DBAccessHelper.ALBUMS_COUNT);
				break;
			case Common.ALBUMS_FRAGMENT:
				mDBColumnsMap.put(GridViewCardsAdapter.TITLE_TEXT, DBAccessHelper.SONG_ALBUM);
				mDBColumnsMap.put(GridViewCardsAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
				mDBColumnsMap.put(GridViewCardsAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
				mDBColumnsMap.put(GridViewCardsAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                mDBColumnsMap.put(GridViewCardsAdapter.FIELD_1, DBAccessHelper.SONG_ARTIST);
				break;
			case Common.PLAYLISTS_FRAGMENT:
				break;
			case Common.GENRES_FRAGMENT:
                mDBColumnsMap.put(GridViewCardsAdapter.TITLE_TEXT, DBAccessHelper.SONG_GENRE);
                mDBColumnsMap.put(GridViewCardsAdapter.SOURCE, DBAccessHelper.SONG_SOURCE);
                mDBColumnsMap.put(GridViewCardsAdapter.FILE_PATH, DBAccessHelper.SONG_FILE_PATH);
                mDBColumnsMap.put(GridViewCardsAdapter.ARTWORK_PATH, DBAccessHelper.SONG_ALBUM_ART_PATH);
                mDBColumnsMap.put(GridViewCardsAdapter.FIELD_1, DBAccessHelper.GENRE_SONG_COUNT);
				break;
			case Common.FOLDERS_FRAGMENT:
				break;
			}
			
		}

