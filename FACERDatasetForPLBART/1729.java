	@Override
	public void onBackPressed() {
		super.onBackPressed();
        if(Constants.D) Log.e(Constants.TAG, "--- ON BACK KEY PRESSED ---");
		stopChatService();
	}

