	private void pickFileOrDirectory() {
		File file = null;
		if (mState == STATE_PICK_FILE) {
			String filename = mEditFilename.getText().toString();
			file = FileUtils.getFile(currentDirectory.getAbsolutePath(), filename);
		} else if (mState == STATE_PICK_DIRECTORY) {
			file = currentDirectory;
		}
		
		PreferenceActivity.setDefaultPickFilePath(this, currentDirectory.getAbsolutePath());
    	 
    	Intent intent = getIntent();
    	intent.setData(FileUtils.getUri(file));
    	setResult(RESULT_OK, intent);
    	finish();
     }

