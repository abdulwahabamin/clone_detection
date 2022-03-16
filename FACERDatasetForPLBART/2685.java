	/**
	 * Accept EULA and proceed with main application.
	 */
	void accept() {
		EulaOrNewVersion.storeCurrentVersionCode(this);
		
		startOriginalActivity();
	}

