		public ArrayList<IndexerFile> searchAbsoluteFile(List<String> terms, int limitStart, int limitEnd) {
			ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();

			Cursor cur =null;
			for(String term: terms) {
                //term="IMG";
				cur=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+IndexerFile.INT_BOOL_ISFOLDER + "=0 AND " +IndexerFile.STRING_FILENAME+" LIKE '%"+Sf.makeDbSafe(term)+"%'  COLLATE NOCASE LIMIT "+limitStart+","+limitEnd,null);
				//cur = db.query(TABLE_NAME, this.getFieldNames(), IndexerFile.STRING_FILENAME + " LIKE ?", new String[]{"%" + term + "%"}, null, null, IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd+" COLLATE NOCASE");
//BLog.e( "DB SEARCH '" + term + "' RESULTS: " + cur.getCount());
				if (cur.getCount() > 0) {
					cur.moveToFirst();
					do {
						items.add(getIndexerFileFromCursor(cur));
					} while (cur.moveToNext());

				}
			}
			if(cur!=null)
				cur.close();

			return items;
		}

