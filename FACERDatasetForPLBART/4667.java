	public void goUpDirectory(Context context) {
		if(!currentPath.equals(File.separator)) {
			currentPath=currentPath.substring(0, currentPath.lastIndexOf(File.separator));
			if(currentPath.length()==0)
				currentPath= File.separator;
			readDirectory(context);
		}			
	}

