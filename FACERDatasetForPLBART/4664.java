	public boolean setCurrentDirectory(Context context,String directory) {
		File dir = new File(directory);
		if(dir.isDirectory() && dir.canRead()) {
			currentPath=directory;
			return true;
			//readDirectory(context);
		}
		return false;
	}

