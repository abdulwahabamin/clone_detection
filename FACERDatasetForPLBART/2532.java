	/**
	 * If multi selection is cancelled, forget all selections
	 */
	@Override
	public void onDestroyActionMode(ActionMode mode) {
		d.getmAdapter().clearSelection();
		d.getFilesMoving().clear();
		d.getSelectedPaths().clear();
		d.setItemsMoving(false);
		d.setCut(false);
		d.setNumMoving(0);
		mode.invalidate();
	}

