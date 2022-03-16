	public static String getPathLessFileName(String fullpath) {
		
		if(fullpath.indexOf("/")!=-1) {
			
			return fullpath.substring(0,fullpath.lastIndexOf("/")+1);
			
		} else {
			return fullpath;
		}

	}

