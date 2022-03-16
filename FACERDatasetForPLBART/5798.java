    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode) {
		case REQUEST_CODE_PICK_FILE_OR_DIRECTORY:
			if (resultCode == RESULT_OK && data != null) {
				Uri destinationUri = data.getData();
				if (destinationUri != null && source != null) {
					String destinationPath = destinationUri.getPath();
					saveFile(new File(destinationPath));
				}
			}
			break;
		}
		finish(); //End the activity
	}

