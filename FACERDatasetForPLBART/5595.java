	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		if (VersionUtils.isPackageAvailable(this, mPackageNames[pos], mMinVersionCodes[pos])) {
			showDialog(DIALOG_INFO + pos);
		} else {
			showDialog(DIALOG_GET_FROM_MARKET + pos);
		}
	}

