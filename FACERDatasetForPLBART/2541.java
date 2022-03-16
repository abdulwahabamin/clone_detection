	/**
	 * Display dialog giving options to confirm or cancel delete
	 */
	public void confirmDelete() {
		// Create an instance of the dialog fragment and show it
		DialogFragment dialog = new NoticeDialogFragment();
		dialog.show(d.getFragmentManager(), "NoticeDialogFragment");
	}

