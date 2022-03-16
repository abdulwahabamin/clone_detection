		public void update(IndexerFile item) {
			ContentValues values = new ContentValues();

			values.put(IndexerFile.STRING_FILENAME, item.getString(IndexerFile.STRING_FILENAME));
            values.put(IndexerFile.STRING_FILEPATH, item.getString(IndexerFile.STRING_FILEPATH).replaceFirst(Files.SDCARD_PATH, ""));
			values.put(IndexerFile.INT_CATEGORY, item.getInt(IndexerFile.INT_CATEGORY));
			values.put(IndexerFile.LONG_FILESIZE, item.getLong(IndexerFile.LONG_FILESIZE));
			values.put(IndexerFile.INT_ICONTYPE, item.getInt(IndexerFile.INT_ICONTYPE));
			values.put(IndexerFile.LONG_MODIFIED, item.getLong(IndexerFile.LONG_MODIFIED));
            values.put(IndexerFile.INT_BOOL_ISFOLDER, item.getInt(IndexerFile.INT_BOOL_ISFOLDER));
			if(db!=null) {
				long id = db.update(TABLE_NAME, values, IndexerFile.LONG_ID + "=?", new String[]{"" + item.getLong(IndexerFile.LONG_ID)});
			}

		}

