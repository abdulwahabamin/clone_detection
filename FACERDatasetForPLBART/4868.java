	public static String getFileNameFromPath(String fullpath) {
		
		if(fullpath.indexOf("/")!=-1) {
			String str[] = fullpath.split("/");
			if(str!=null) {
				return str[str.length-1];
			}
		} else {
			return fullpath;
		}
		
		return "";
	}

