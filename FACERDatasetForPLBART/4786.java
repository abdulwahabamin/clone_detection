		public HashMap<String,IndexerFile> getSubFolderCategories(String parentFolder) {
			HashMap<String,IndexerFile> items = new HashMap<String,IndexerFile>();
            parentFolder=parentFolder.replaceFirst(Files.SDCARD_PATH,"");
            //BLog.e(parentFolder);
			//Cursor cur = db.query(TABLE_NAME, this.getFieldNames(),IndexerFile.STRING_FILEPATH +"=?", new String[]{parentFolder}, null, null, null);
            //Cursor cur = db.query(TABLE_NAME, this.getFieldNames(),IndexerFile.INT_BOOL_ISFOLDER +"=1 AND "+IndexerFile.STRING_FILEPATH +"?", new String[]{parentFolder+"%"}, null, null, null);
            Cursor cur=db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + IndexerFile.INT_BOOL_ISFOLDER + "=1 AND " + IndexerFile.STRING_FILEPATH + " LIKE '" + Sf.makeDbSafe(parentFolder) + "%'  COLLATE NOCASE", null);

			if(cur.getCount()>0) {
				cur.moveToFirst();
				do {
					IndexerFile iff=getIndexerFileFromCursor(cur);
					items.put(iff.getString(IndexerFile.STRING_FILENAME), iff);
				} while(cur.moveToNext());

			}

			cur.close();

			return items;
		}

