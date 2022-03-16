	/**
	 * Actions for when item is either checked or unchecked
	 */
	@Override
	public void onItemCheckedStateChanged(ActionMode mode, int position,
			long id, boolean checked) {
		if (!d.isItemsMoving()) {
			if (checked) {
				String path = d.getmAdapter().getItem(position);
				d.setNumMoving(d.getNumMoving()+1);
				d.getmAdapter().setNewSelection(path, position, true);
				mode.setTitle(d.getNumMoving() + " items selected");
			} else if (!checked) {
				d.setNumMoving(d.getNumMoving()-1);
				d.getmAdapter().removeSelection(position);
			}
			mode.setTitle(d.getNumMoving() + " items selected");
			mode.invalidate();
		}
		if (d.isItemsMoving()) {
			String clickedItem = d.getmAdapter().getItem(position);
			// Update path and listview to new directory based on what was
			// clicked
			d.setPath(clickedItem);
			d.populateFiles();
			d.getmAdapter().notifyDataSetChanged();
			mode.invalidate();
		}
	}

