	public void onPrepareDialog(int id, Dialog dialog) {
		switch (id - mFirstDialogId) {
		case OFFSET_ABOUT:
			AboutDialog.onPrepareDialog(mActivity, dialog);
			break;
		}
	}

