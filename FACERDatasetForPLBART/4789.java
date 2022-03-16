		public ArrayList<IndexerFile> searchByModifiedDate(long dateLT, long dateGT, int limitStart, int limitEnd) {
			ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();
			String whereStr = IndexerFile.LONG_MODIFIED+"<"+dateLT+" AND "+IndexerFile.LONG_MODIFIED+">"+dateGT;
			if(dateGT<1)
				whereStr = IndexerFile.LONG_MODIFIED+"<"+dateLT;
			else if(dateLT<1)
				whereStr = IndexerFile.LONG_MODIFIED+">"+dateGT;

			Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + whereStr + " ORDER BY " + IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd, null);

			if(cur.getCount()>0) {
				cur.moveToFirst();
				do {
					items.add(getIndexerFileFromCursor(cur));
				} while(cur.moveToNext());

			}

			cur.close();

			return items;
		}

