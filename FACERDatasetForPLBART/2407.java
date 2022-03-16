	private void promptDestinationAndMoveFile() {

		Intent intent = new Intent(FileManagerIntents.ACTION_PICK_DIRECTORY);
		
		intent.setData(FileUtils.getUri(currentDirectory));
		
		intent.putExtra(FileManagerIntents.EXTRA_TITLE, getString(R.string.move_title));
		intent.putExtra(FileManagerIntents.EXTRA_BUTTON_TEXT, getString(R.string.move_button));
		
		startActivityForResult(intent, REQUEST_CODE_MOVE);
	}

