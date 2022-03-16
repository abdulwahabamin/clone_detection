	@Override
	protected void setupService() {
		super.setupService();

		countDownLatch = new CountDownLatch(HANDLED_INTENT_COUNT);
		getService().setLatch(countDownLatch);
	}

