		public long add(IndexerFile item) {

			if(item!=null && db!=null) {
				ContentValues values = new ContentValues();
                //if(item.getAsFileItem().isDirectory())
                //    BLog.e("ADD TO DB: "+item.getString(IndexerFile.STRING_FILENAME));
				values.put(IndexerFile.STRING_FILENAME, item.getString(IndexerFile.STRING_FILENAME));
				values.put(IndexerFile.STRING_FILEPATH, item.getString(IndexerFile.STRING_FILEPATH).replaceFirst(Files.SDCARD_PATH, ""));
				values.put(IndexerFile.INT_CATEGORY, item.getInt(IndexerFile.INT_CATEGORY));
				values.put(IndexerFile.LONG_FILESIZE, item.getLong(IndexerFile.LONG_FILESIZE));
				values.put(IndexerFile.INT_ICONTYPE, item.getInt(IndexerFile.INT_ICONTYPE));
				values.put(IndexerFile.LONG_MODIFIED, item.getLong(IndexerFile.LONG_MODIFIED));
                values.put(IndexerFile.INT_BOOL_ISFOLDER, item.getInt(IndexerFile.INT_BOOL_ISFOLDER));
				return db.insert(TABLE_NAME, null, values);
			}
			return -1;
		}

