    /**
     * This is called after the file manager finished.
     */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case REQUEST_CODE_MOVE:
			if (resultCode == RESULT_OK && data != null) {
				// obtain the filename
				File movefrom = mContextFile;
				File moveto = FileUtils.getFile(data.getData());
				if (moveto != null) {
					if (mState != STATE_MULTI_SELECT) {
					    // Move single file.
                        moveto = FileUtils.getFile(moveto, movefrom.getName());
						int toast = 0;
						if (movefrom.renameTo(moveto)) {
							// Move was successful.
						    refreshList();
				            if (moveto.isDirectory()) {
								toast = R.string.folder_moved;
							} else {
								toast = R.string.file_moved;
							}
						} else {
							if (moveto.isDirectory()) {
								toast = R.string.error_moving_folder;
							} else {
								toast = R.string.error_moving_file;
							}
						}
						Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
					} else {
    					// Move multi file.
                        int toast = 0;
                        for (IconifiedText it : mDirectoryEntries) {
                            if (!it.isSelected()) {
                                continue;
                            }

                            movefrom = FileUtils.getFile(currentDirectory, it.getText());
					        File newPath = FileUtils.getFile(moveto, movefrom.getName());
                            if (!movefrom.renameTo(newPath)) {
                                refreshList();
                                if (moveto.isDirectory()) {
                                    toast = R.string.error_moving_folder;
                                } else {
                                    toast = R.string.error_moving_file;
                                }
                                break;
                            }
					    }

                        if (toast == 0) {
                            // Move was successful.
                            refreshList();
                            toast = R.string.file_moved;
                        }

                        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();

                        Intent intent = getIntent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
						
				}				
				
			}
			break;
        
        case REQUEST_CODE_EXTRACT:
            if (resultCode == RESULT_OK && data != null) {
                new ExtractManager(this).extract(mContextFile, data.getData().getPath());
            }
            break;

		case REQUEST_CODE_COPY:
			if (resultCode == RESULT_OK && data != null) {
				// obtain the filename
				File copyfrom = mContextFile;
				File copyto = FileUtils.getFile(data.getData());
				if (copyto != null) {
                    if (mState != STATE_MULTI_SELECT) {
                        // Copy single file.
                        copyto = createUniqueCopyName(this, copyto, copyfrom.getName());
                        
                        if (copyto != null) {
                            int toast = 0;
                            if (copy(copyfrom, copyto)) {
                                toast = R.string.file_copied;
                                refreshList();
                            } else {
                                toast = R.string.error_copying_file;
                            }
                            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Copy multi file.
                        int toast = 0;
                        for (IconifiedText it : mDirectoryEntries) {
                            if (!it.isSelected()) {
                                continue;
                            }

                            copyfrom = FileUtils.getFile(currentDirectory, it.getText());
                            File newPath = createUniqueCopyName(this, copyto, copyfrom.getName());
                            if (copyto != null) {
                                if (!copy(copyfrom, newPath)) {
                                    toast = R.string.error_copying_file;
                                    break;
                                }
                            }
                        }

                        if (toast == 0) {
                            // Copy was successful.
                            toast = R.string.file_copied;
                            refreshList();
                        }

                        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();

                        Intent intent = getIntent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
				}				
			}
			break;

        case REQUEST_CODE_MULTI_SELECT:
            if (resultCode == RESULT_OK && data != null) {
                refreshList();
            }
            break;
        }
		
	}

