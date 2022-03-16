	@MediumTest
	public void testRecordUpdates() {
		final String SELECTION_COLUMNS = CityTable.COLUMN_CITY_ID + " = " + "?";
		final String[] SELECTION_ARGS = { "100" };

		ContentValues newTestValues = new ContentValues();
		int NEW_CITY_ID = 1000;
		newTestValues.put(CityTable.COLUMN_CITY_ID, NEW_CITY_ID);

		int rowsUpdatedBeforeDataInsertion = mockContentResolver.update(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS, newTestValues,
				SELECTION_COLUMNS, SELECTION_ARGS);

		assertEquals(
				"No rows should have been updated since test data is not yet inserted",
				0, rowsUpdatedBeforeDataInsertion);

		insertInitialTestData();

		int rowsUpdatedAfterDataInsertion = mockContentResolver.update(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS, newTestValues,
				SELECTION_COLUMNS, SELECTION_ARGS);

		assertEquals("Exactly one row should have been updated)", 1,
				rowsUpdatedAfterDataInsertion);
	}

