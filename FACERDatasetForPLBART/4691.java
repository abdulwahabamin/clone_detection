	public FileItem getDirectoryItem(int index) {
		//BLog.e("LLL","get FI index: "+index);
		if(fileList!= null && index<fileList.size())
			return fileList.get(index);
		return null;
	}

