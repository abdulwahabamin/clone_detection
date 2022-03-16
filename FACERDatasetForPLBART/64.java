	@Override
	public void onBackPressed() {
		if (chatService != null) {
			chatService.stop();
			chatService = null;
		}
		finish();
		super.onBackPressed();
	}

