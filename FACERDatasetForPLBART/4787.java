		public ArrayList<IndexerFile> searchByCategory(int category, int limitStart, int limitEnd) {
			ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();
			Cursor cur = db.query(TABLE_NAME, this.getFieldNames(), IndexerFile.INT_CATEGORY + "=?", new String[]{category + ""}, null, null, IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd);

			if(cur.getCount()>0) {
				cur.moveToFirst();
				do {
					items.add(getIndexerFileFromCursor(cur));
				} while(cur.moveToNext());

			}

			cur.close();

			return items;
		}

