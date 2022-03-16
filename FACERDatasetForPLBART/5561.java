	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id - mFirstMenuId) {
		case OFFSET_UPDATE:
			mActivity.showDialog(mFirstDialogId + OFFSET_UPDATE);
			return true;
		case OFFSET_ABOUT:
			AboutDialog.showDialogOrStartActivity(mActivity, 
					mFirstDialogId + OFFSET_ABOUT);
			return true;
		}
		return false;
	}

