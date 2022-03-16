	/**
	 * Accept EULA and proceed with main application.
	 */
	void accept() {
		EulaOrNewVersion.storeEulaAccepted(this);
		
		startOriginalActivity();
	}

