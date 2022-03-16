	public boolean open() {
		if(db==null || !db.isOpen()) {
			Files.ensurePath(Files.HOME_PATH_FILES);
			try {
		        db = context.openOrCreateDatabase(
		        		DATABASE_FILE
		       		, SQLiteDatabase.CREATE_IF_NECESSARY
		       		, null
                        ,bderrorhandler
		      		);
			} catch(Exception e) {
				//BLog.add("DB open() error, cannot open or create DB."+DATABASE_FILE);
			}
		}
		if(db!=null && db.isOpen()) {
			return true;
		} else {
			return false;
		}
	}

