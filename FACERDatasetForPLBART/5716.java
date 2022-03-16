    private void renameFileOrFolder(File file, String newFileName) {
        mOldFileName = file.getName();
        mNewFileName = newFileName;
        mDialogArgument = mNewFileName;
		if (newFileName != null && newFileName.length() > 0){
			if (!file.isDirectory() && !FileUtils.getExtension(newFileName).equals(FileUtils.getExtension(file.getName()))){
                showDialog(DIALOG_CHANGE_FILE_EXTENSION);
                return;
			}
		}
		File newFile = FileUtils.getFile(currentDirectory, newFileName);
        if (newFile.exists()){
            mDialogExistsAction = DIALOG_EXISTS_ACTION_RENAME;
            showDialog(DIALOG_WARNING_EXISTS);
        } else {
            rename(file, newFile);
        }
	}

