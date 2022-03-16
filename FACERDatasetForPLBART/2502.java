	/**
	 * TO DO: MOVE ELSEWHERE
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (itemsMoving) {
			if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
					&& event.getAction() == KeyEvent.ACTION_UP) {
				File currentDirectory = new File(path);
				path = currentDirectory.getParent();
				populateFiles();
				mAdapter.notifyDataSetChanged();
				return true;
			}
			return true; // consumes the back key event - ActionMode is not
							// finished
		}

		return super.dispatchKeyEvent(event);
	}

