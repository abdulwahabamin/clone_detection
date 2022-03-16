	public static FileManager getCachedFileManager(Class<? extends FileManager> ofType) {
		for(FileManager fm: S.cachedFileManagers) {
			if(fm.getClass().equals(ofType)) {
				//Log.e("TST", "getCachedFileManager: "+ fm.getClass() + " - " + ofType);
				return fm;
			}
		}
		return null;
	}

