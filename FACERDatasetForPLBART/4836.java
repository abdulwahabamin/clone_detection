	public long getFilesize() {
		if(fileSize==-1) {
			File f = new File(path+ File.separator+filename);
			if(f.exists())
				fileSize=f.length();
			else
				fileSize=0;
		}
		return fileSize;
	}

