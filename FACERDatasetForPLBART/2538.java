	/**
	 * Cut option was selected
	 * @param mode The action mode in use
	 * @return If the action was successful
	 */
	public boolean contextCut(ActionMode mode) {
		d.setCut(true);
		d.setItemsMoving(true);
		d.setSelectedPaths(d.getmAdapter().getCurrentPaths());
		d.setNumMoving(d.getSelectedPaths().size());
		for (int i = 0; i < d.getSelectedPaths().size(); i++) {
			d.getFilesMoving().add(new File(d.getSelectedPaths().get(i)));
		}
		mode.setTitle("Preparing to cut..");
		mode.invalidate();
		d.getmAdapter().clearSelection();
		return true;
	}

