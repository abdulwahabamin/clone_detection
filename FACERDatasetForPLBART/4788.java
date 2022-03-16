        public ArrayList<IndexerFile> getFoldersByCategory(int category, int limitStart, int limitEnd) {
            ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();
			Cursor cur=null;
			if(category==Files.CAT_ANY) {
				//cur = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + IndexerFile.INT_BOOL_ISFOLDER+"=1 ORDER BY " + IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd, null);
				cur = db.query(TABLE_NAME, this.getFieldNames(), IndexerFile.INT_BOOL_ISFOLDER+"=1", null, null, null, IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd);
			} else {
				cur = db.query(TABLE_NAME, this.getFieldNames(), IndexerFile.INT_CATEGORY + "=? AND "+IndexerFile.INT_BOOL_ISFOLDER+"=1", new String[]{category + ""}, null, null, IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd);
			}


            if(cur.getCount()>0) {
                cur.moveToFirst();
                do {
                    items.add(getIndexerFileFromCursor(cur));
                } while(cur.moveToNext());

            }

            cur.close();

            return items;
        }

