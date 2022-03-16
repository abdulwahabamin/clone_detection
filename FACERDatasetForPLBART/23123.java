	public synchronized static PlayQueue getInstance() {
		if (singleton == null) {
			singleton = new PlayQueue();
		}
		return singleton;
	}

