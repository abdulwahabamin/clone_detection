		public ArrayList<IndexerFile> getItems(int limitStart, int limitEnd) {
			ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();
			if(db!=null) {
				Cursor cur = db.query(TABLE_NAME, this.getFieldNames(), null, null, null, null, IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd);

				if (cur.getCount() > 0) {
					cur.moveToFirst();
					do {
						items.add(getIndexerFileFromCursor(cur));
					} while (cur.moveToNext());

				}

				cur.close();
			}

			return items;
		}

