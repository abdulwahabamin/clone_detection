	private void deleteFileOrFolder(File file) {
		fileDeleted = true;
		positionAtDelete = getListView().getFirstVisiblePosition();
		deletedFileIsDirectory = file.isDirectory();
		new RecursiveDeleteTask().execute(file);
//		if (file.isDirectory()) {
//			if (recursiveDelete(file, true)) {
//				refreshList();
//				Toast.makeText(this, R.string.folder_deleted, Toast.LENGTH_SHORT).show();
//			}
//		} else {
//			if (file.delete()) {
//				// Delete was successful.
//				refreshList();
//				Toast.makeText(this, R.string.file_deleted, Toast.LENGTH_SHORT).show();
//			} else {
//				Toast.makeText(this, R.string.error_deleting_file, Toast.LENGTH_SHORT).show();
//			}
//		}
	}

