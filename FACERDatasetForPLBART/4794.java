		public boolean hasItem(String filename, String filepath) {
			boolean alreadyHasFeed=false;
			if(db!=null) {
				Cursor cur = db.query(TABLE_NAME, this.getFieldNames(),
						IndexerFile.STRING_FILENAME + "=? AND " + IndexerFile.STRING_FILEPATH + "=?", new String[]{filename, filepath.replaceFirst(Files.SDCARD_PATH,"")}, null, null, null);


				if (cur != null && cur.getCount() > 0)
					alreadyHasFeed = true;
				cur.close();
			}
			return alreadyHasFeed;
		}

