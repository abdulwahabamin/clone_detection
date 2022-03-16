	private void startPickActivity(Intent intent){
		try {
			startActivityForResult(intent, REQUEST_CODE_PICK_FILE_OR_DIRECTORY);
		} catch (ActivityNotFoundException e) {
			//Should never happen, but Java requires this catch
			Toast.makeText(this, R.string.saveas_error, Toast.LENGTH_SHORT).show();
		}
	}

