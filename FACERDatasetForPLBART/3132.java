    /**
     * This is called after the file manager finished.
     */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {
		case REQUEST_CODE_MOVE:
			if (resultCode == RESULT_OK && data != null) {
				// obtain the filename
				File movefrom = mContextFile;
				File moveto = FileUtils.getFile(data.getData());
				if (moveto != null) {
					moveto = FileUtils.getFile(moveto, movefrom.getName());
					move(movefrom, moveto);
				}				
				
			}
			break;

		case REQUEST_CODE_COPY:
			if (resultCode == RESULT_OK && data != null) {
				// obtain the filename
				File copyfrom = mContextFile;
				File copyto = FileUtils.getFile(data.getData());
				if (copyto != null) {
					copyto = createUniqueCopyName(this, copyto, copyfrom.getName());
					
					if (copyto != null) {
						copy(copyfrom, copyto);
					}
				}				
			}
			break;
}
	}

