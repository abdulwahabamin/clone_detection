	@Override
	public void onStart() {
		super.onStart();
		if (chatService == null)
			setupChat();
	}

