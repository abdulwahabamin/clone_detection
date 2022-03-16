	private void renameFileOrFolder(File file, String newFileName) {
		
		File newFile = FileUtils.getFile(currentDirectory, newFileName);
		
		rename(file, newFile);
	}

