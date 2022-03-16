	@MediumTest
	public void testRecordDeletions() {
		final String SELECTION_COLUMNS = CityTable.COLUMN_CITY_ID + " = " + "?";
		final String[] SELECTION_ARGS = { "100" };

		int rowsDeletedBeforeDataInsertion = mockContentResolver.delete(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
				SELECTION_COLUMNS, SELECTION_ARGS);

		assertEquals(
				"No rows should have been deleted since test data is not yet inserted",
				0, rowsDeletedBeforeDataInsertion);

		insertInitialTestData();

		int rowsDeletedAfterDataInsertion = mockContentResolver.delete(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
				SELECTION_COLUMNS, SELECTION_ARGS);

		assertEquals("Exactly one row should have been deleted)", 1,
				rowsDeletedAfterDataInsertion);
	}

