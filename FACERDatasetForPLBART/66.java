	@Override
	public synchronized void onResume() {
		super.onResume();
		if (chatService != null) {
			if (chatService.getState() == LanylService.STATE_NONE) {
				chatService.start();
			}
		}
	}

