	/**
	 * Starts activity for multi select.
	 */
	private void promptMultiSelect() {
        Intent intent = new Intent(FileManagerIntents.ACTION_MULTI_SELECT);
        
        intent.setData(FileUtils.getUri(currentDirectory));
        
        intent.putExtra(FileManagerIntents.EXTRA_TITLE, getString(R.string.multiselect_title));
        //intent.putExtra(FileManagerIntents.EXTRA_BUTTON_TEXT, getString(R.string.move_button));

        startActivityForResult(intent, REQUEST_CODE_MULTI_SELECT);
    }

