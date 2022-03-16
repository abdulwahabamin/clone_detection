	private Intent getRenameCityIntent() {
		Intent intent = getNewIntentForDatabaseOperation();
		intent.setAction(GeneralDatabaseService.ACTION_RENAME_CITY);
		intent.putExtra(CityManagementActivity.CITY_ID, TEST_CITY_ID);
		intent.putExtra(CityManagementActivity.CITY_NEW_NAME,
				TEST_NEW_CITY_NAME);
		return intent;
	}

