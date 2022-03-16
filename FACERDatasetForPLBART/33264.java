	private Intent getDeleteCityIntent() {
		Intent intent = getNewIntentForDatabaseOperation();
		intent.setAction(GeneralDatabaseService.ACTION_DELETE_CITY_RECORDS);
		intent.putExtra(MainActivity.CITY_ID, TEST_CITY_ID);
		return intent;
	}

