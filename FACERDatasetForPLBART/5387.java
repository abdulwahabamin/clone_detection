	boolean isDirToExclude(String dir){
		for(String directory:excludedDir){
			if(directory.equalsIgnoreCase(dir))
				return true;
		}
		return false;
	}

