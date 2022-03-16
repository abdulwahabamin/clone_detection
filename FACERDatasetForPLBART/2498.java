	/**
	 * Creates and attaches a multi choice listener to the listview so multiple
	 * items can be selected
	 */
	public void setupListViewMulti() {
		// Find the listview
		lv = (AbsListView) findViewById(R.id.gridView);

		// Set listview to multiple selection mode
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		lv.setMultiChoiceModeListener(new MultiChoiceModeListenerImpl(this));
	}

