	@LargeTest
	public void testHandleIntent() throws InterruptedException {
		Intent insertNewCityIntent = getInsertNewCityIntent();
		startService(insertNewCityIntent);

		Intent renameCityIntent = getRenameCityIntent();
		startService(renameCityIntent);

		Intent deleteCityIntent = getDeleteCityIntent();
		startService(deleteCityIntent);

		boolean wereIntentsHandledInTime = countDownLatch.await(
				SECONDS_TO_HANDLE_ALL_TESTED_INTENTS, TimeUnit.SECONDS);

		assertTrue("Failed to handle all " + HANDLED_INTENT_COUNT
				+ " intents in a reasonable time", wereIntentsHandledInTime);
	}

