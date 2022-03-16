    private void renameFileOrFolder(File file, String newFileName) {
		
		if (newFileName != null && newFileName.length() > 0){
			if (newFileName.lastIndexOf('.') < 0){				
				newFileName += FileUtils.getExtension(file.getName()); 
			}
		}
		File newFile = FileUtils.getFile(currentDirectory, newFileName);
		
		rename(file, newFile);
	}

