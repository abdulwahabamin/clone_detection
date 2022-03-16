	public FileManagerZip(String zipFileAbsolutePath) {
		//zipFile=zipFileAbsolutePath;
		currentPath= zipFileAbsolutePath;
		try {
			useZipFile = new ZipFile(zipFileAbsolutePath);
		} catch(Exception e) {
			okFile=false;
		}
	}

