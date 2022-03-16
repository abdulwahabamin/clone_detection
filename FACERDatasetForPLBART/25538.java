	/**
	 * Gets the root storage directory of this device.
	 * @return
	 */
	static File getRootStorageDirectory() {
		File ext = Environment.getExternalStorageDirectory();
		if(ext == null){
			ext = Environment.getRootDirectory();
			return ext;
		}
		File parent = ext.getParentFile();
		if (parent != null) {
			return parent;
		}
		return ext;
	}

