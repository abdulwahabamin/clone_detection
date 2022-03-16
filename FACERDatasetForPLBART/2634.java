	private void excludeFromMediaScan() {
		// Create the .nomedia file.
		File file = FileUtils.getFile(currentDirectory, NOMEDIA_FILE);
		try {
			if (file.createNewFile()) {
				mNoMedia = true;
				Toast.makeText(this, getString(R.string.media_scan_excluded), Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(this, getString(R.string.error_media_scan), Toast.LENGTH_LONG).show();
			}
		} catch (IOException e) {
			// That didn't work.
			Toast.makeText(this, getString(R.string.error_generic) + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

