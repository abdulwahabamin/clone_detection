	public static void popCachedFileManager(Class<? extends FileManager> ofType) {
		for(FileManager fm: S.cachedFileManagers) {
			if(fm.getClass().equals(ofType))
				S.cachedFileManagers.remove(fm);
		}
	}

