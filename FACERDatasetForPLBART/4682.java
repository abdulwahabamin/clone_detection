	public void setCurrentDirectory(Context context,String directory) {
		File dir = new File(directory);
		if(dir.isDirectory()) {
			currentPath=directory;
			//readDirectory(context);
		}
	}

