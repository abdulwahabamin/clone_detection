		private IndexerFile getIndexerFileFromCursor(Cursor cursor) {
			return new IndexerFile(cursor.getLong(cursor.getColumnIndex(IndexerFile.LONG_ID))
					,cursor.getString(cursor.getColumnIndex(IndexerFile.STRING_FILENAME))
					,Files.SDCARD_PATH+ cursor.getString(cursor.getColumnIndex(IndexerFile.STRING_FILEPATH))
					,cursor.getInt(cursor.getColumnIndex(IndexerFile.INT_CATEGORY))
					,cursor.getLong(cursor.getColumnIndex(IndexerFile.LONG_FILESIZE))
					,cursor.getInt(cursor.getColumnIndex(IndexerFile.INT_ICONTYPE))
					,cursor.getLong(cursor.getColumnIndex(IndexerFile.LONG_MODIFIED))
                    ,cursor.getInt(cursor.getColumnIndex(IndexerFile.INT_BOOL_ISFOLDER))
			);

		}

