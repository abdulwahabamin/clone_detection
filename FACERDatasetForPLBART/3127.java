	/**
	 * @param oldFile
	 * @param newFile
	 */
	private void move(File oldFile, File newFile) {
		int toast = 0;
		if (oldFile.renameTo(newFile)) {
			// Rename was successful.
			refreshList();
			if (newFile.isDirectory()) {
				toast = R.string.folder_moved;
			} else {
				toast = R.string.file_moved;
			}
		} else {
			if (newFile.isDirectory()) {
				toast = R.string.error_moving_folder;
			} else {
				toast = R.string.error_moving_file;
			}
		}
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

