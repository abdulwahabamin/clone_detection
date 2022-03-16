	/**
	 * Switch based on menu option clicked
	 */
	@Override
	public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.context_delete:
			return contextDelete(mode);

		case R.id.context_copy:
			return contextCopy(mode);

		case R.id.context_cut:
			return contextCut(mode);

		case R.id.context_accept_paste:
			return contextAcceptPaste(mode);

		case R.id.context_cancel_paste:
			return contextCancelPaste(mode);

		default:
			return false;
		}

	}

