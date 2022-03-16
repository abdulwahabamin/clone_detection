	public Dialog onCreateDialog(int id) {
		switch (id - mFirstDialogId) {
		case OFFSET_ABOUT:
			return new AboutDialog(mActivity);
		case OFFSET_UPDATE:
			return new UpdateDialog(mActivity);
		}
		return null;
	}

