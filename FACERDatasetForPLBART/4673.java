	public FileItem getDirectoryItem(int index) {
		//BLog.e("LLL","get FI index: "+index);
		if(useRaw) {
            if(rawList!=null && rawList.size()>index) {
                return new FileItem(currentPath + File.separator + rawList.get(index));
            } else {
                return null;
            }
		}

		if(fileList!= null && index<fileList.size())
			return fileList.get(index);
		return null;
	}

