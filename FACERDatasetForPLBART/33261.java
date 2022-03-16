	private Intent getInsertNewCityIntent() {
		Intent intent = getNewIntentForDatabaseOperation();
		intent.setAction(GeneralDatabaseService.ACTION_INSERT_OR_UPDATE_CITY_RECORD);
		intent.putExtra(MainActivity.CITY_ID, TEST_CITY_ID);
		intent.putExtra(MainActivity.CITY_NAME, TEST_CITY_NAME);
		intent.putExtra(RefreshingActivity.WEATHER_INFO_JSON_STRING,
				GlobalConstants.TEST_JSON_STRING_VALUE);
		return intent;
	}

