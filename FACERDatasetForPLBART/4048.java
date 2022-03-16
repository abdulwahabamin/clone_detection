	public static void addCachedFileManager(FileManager filemanager) {
		S.cachedFileManagers.add(0,filemanager);
		for(FileManager fm: S.cachedFileManagers) {
			if(fm.getClass().equals(filemanager.getClass()) && !fm.equals(filemanager))
				fm.close();
		}
        System.gc();
		//S.cachedFileManager =filemanager;
	}

