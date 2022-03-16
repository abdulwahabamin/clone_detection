	private void includeInMediaScan() {
		// Delete the .nomedia file.
		File file = FileUtils.getFile(currentDirectory, NOMEDIA_FILE);
		if (file.delete()) {
			Toast.makeText(this, getString(R.string.media_scan_included), Toast.LENGTH_LONG).show();
			mNoMedia = false;
		} else {
			// That didn't work.
			Toast.makeText(this, getString(R.string.error_generic), Toast.LENGTH_LONG).show();
		}
	}

