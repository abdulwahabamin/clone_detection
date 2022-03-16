	/**
	 * Override back button to move up one level in the filesystem on press
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (path.length() > 15) {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
				File currentDirectory = new File(path);
				path = currentDirectory.getParent();
				populateFiles();
				mAdapter.notifyDataSetChanged();
				return true;
			} else
				finish();
		}

		return super.onKeyDown(keyCode, event);
	}

