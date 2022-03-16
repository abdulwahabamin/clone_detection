	public static String getExtension(String fileOrFilePath) {
		if(fileOrFilePath!=null && fileOrFilePath.length()>2) {
			int extp=fileOrFilePath.lastIndexOf(".");
			if(extp>0) {
				return fileOrFilePath.substring(extp);
			}
		}
		return null;
	}

