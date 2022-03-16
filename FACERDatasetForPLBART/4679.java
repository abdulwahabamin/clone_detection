	public FileManagerFolders(String rootFolder) {
		rootPath=rootFolder;
		currentPath= rootFolder;
		if(currentPath==null)
			currentPath=loadPath;
	}

