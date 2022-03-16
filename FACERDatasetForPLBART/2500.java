	/**
	 * Creates and attaches an onclicklistener to the listview to handle when
	 * files/folders are clicked
	 */
	private void setupListClick() {
		// Create onClickListener to allow action of clicking listview items
		lv.setOnItemClickListener(new OnItemClickListenerImpl(this));
	}

