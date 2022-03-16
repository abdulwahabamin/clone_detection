	@Override
	public void onDestroy() {
		super.onDestroy();
		if (chatService != null) {
			chatService.stop();
			chatService = null;
		}
	}

