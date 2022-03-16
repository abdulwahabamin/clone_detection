	/**
	 * Creates and attaches an adapter to the listview so the data may be
	 * manipulated
	 */
	public void setupAdapter() {
		// Create a new adapter with the context, row layout, textview id tag
		// and the current files
		mAdapter = new SelectionAdapter(getBaseContext(),
				R.layout.row_list_item, R.id.file, currentFileList);
		// Set the new adapter to the ListView
		lv.setAdapter(mAdapter);
	}

