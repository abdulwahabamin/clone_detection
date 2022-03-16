	/**
	 * Paste option was cancelled
	 * @param mode The action mode in use
	 * @return If the action was successful
	 */
	public boolean contextCancelPaste(ActionMode mode) {
		mode.finish();
		return true;
	}

