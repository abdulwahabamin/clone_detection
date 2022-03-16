		public ArrayList<IndexerFile> getImageVideoItems(int limitStart, int limitEnd) {
			ArrayList<IndexerFile> items = new ArrayList<IndexerFile>();
			if(db!=null) {
				Cursor cur = db.query(TABLE_NAME, this.getFieldNames(), IndexerFile.INT_CATEGORY+"="+Files.CAT_IMAGE +" OR "+IndexerFile.INT_CATEGORY+"="+Files.CAT_VIDEO, null, null, null, IndexerFile.LONG_MODIFIED + " DESC LIMIT " + limitStart + "," + limitEnd);

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

