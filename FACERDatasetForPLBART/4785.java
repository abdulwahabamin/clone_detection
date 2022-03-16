		public ArrayList<IndexerFile> searchAbsoluteFile(String term, int limitStart, int limitEnd) {
			ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();
            Cursor cur=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+IndexerFile.INT_BOOL_ISFOLDER + "=0 AND " +IndexerFile.STRING_FILENAME+" LIKE '%"+Sf.makeDbSafe(term)+"%'  COLLATE NOCASE LIMIT "+limitStart+","+limitEnd,null);
			//Cursor cur = db.query(TABLE_NAME, this.getFieldNames(),IndexerFile.STRING_FILENAME +"=?", new String[]{"%"+term+"%"}, null, null, IndexerFile.LONG_MODIFIED +" DESC LIMIT "+limitStart+","+limitEnd);

			if(cur.getCount()>0) {
				cur.moveToFirst();
				do {
					items.add(getIndexerFileFromCursor(cur));
				} while(cur.moveToNext());

			}

			cur.close();

			return items;
		}

