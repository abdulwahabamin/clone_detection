	/**
	 * @param oldFile
	 * @param newFile
	 */
	private void rename(File oldFile, File newFile) {
		int toast = 0;
		if (oldFile.renameTo(newFile)) {
			// Rename was successful.
			refreshList();
			if (newFile.isDirectory()) {
				toast = R.string.folder_renamed;
			} else {
				toast = R.string.file_renamed;
			}
		} else {
			if (newFile.isDirectory()) {
				toast = R.string.error_renaming_folder;
			} else {
				toast = R.string.error_renaming_file;
			}
		}
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

