	private void promptDestinationAndCopyFile() {

		Intent intent = new Intent(FileManagerIntents.ACTION_PICK_DIRECTORY);
		
		intent.setData(FileUtils.getUri(currentDirectory));
		
		intent.putExtra(FileManagerIntents.EXTRA_TITLE, getString(R.string.copy_title));
		intent.putExtra(FileManagerIntents.EXTRA_BUTTON_TEXT, getString(R.string.copy_button));
		intent.putExtra(FileManagerIntents.EXTRA_WRITEABLE_ONLY, true);
		
		startActivityForResult(intent, REQUEST_CODE_COPY);
	}

