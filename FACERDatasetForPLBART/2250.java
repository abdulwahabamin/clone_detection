    private void createNewFolder(String foldername) {
		if (!TextUtils.isEmpty(foldername)) {
			File file = FileUtils.getFile(currentDirectory, foldername);
			if (file.mkdirs()) {
				
				// Change into new directory:
				browseTo(file);
			} else {
				Toast.makeText(this, R.string.error_creating_new_folder, Toast.LENGTH_SHORT).show();
			}
		}
	}

