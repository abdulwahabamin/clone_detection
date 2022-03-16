	/**
	 * Delete option was selected
	 * @param mode The action mode in use
	 * @return If the action was successful
	 */
	public boolean contextDelete(ActionMode mode) {
		d.setMode(mode);
		confirmDelete();
		return true;
	}

