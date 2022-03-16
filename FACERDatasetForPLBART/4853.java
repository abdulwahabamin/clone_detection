	public static int getFileRIcon(String fileOrFilePath) {
		if(fileOrFilePath!=null && fileOrFilePath.length()>4) {
			fileOrFilePath=removeBriefFileExtension(fileOrFilePath);
			int extp=fileOrFilePath.lastIndexOf(".");
			if(extp>0) {
				String ext=fileOrFilePath.substring(extp).toLowerCase();

				Integer Rval = IMG_FILES.get(ext);
				if(Rval!=null) 
					return Rval.intValue();
			} else {
				return F_DIR;
			}
		}
		return F_NO;
	}

