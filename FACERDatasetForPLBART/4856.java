	public static String getFilenameLessExtension(String fileOrFilePath) {
		if(fileOrFilePath!=null && fileOrFilePath.length()>2) {
			int extp=fileOrFilePath.lastIndexOf(".");
			if(extp>0) {
				return fileOrFilePath.substring(0,extp);
			}
		}
		return null;
	}

