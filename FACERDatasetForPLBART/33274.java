	@SmallTest
	public void testQueriesOnCityWeatherUri_projectionColumns() {

		final String[] TEST_PROJECTION = { CityTable.COLUMN_CITY_ID,
				CityTable.COLUMN_NAME,
				CityTable.COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER,
				CityTable.COLUMN_CACHED_JSON_CURRENT };

		Cursor cursor = mockContentResolver.query(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
				TEST_PROJECTION, null, null, null);
		int expectedColumnCount = TEST_PROJECTION.length;
		int actualColumnCount = cursor.getColumnCount();

		assertEquals("Projection contains " + expectedColumnCount
				+ " columns, but the cursor has " + actualColumnCount,
				expectedColumnCount, actualColumnCount);

		// Asserts that the names of the columns in the cursor and in the
		// projection are the same, and in the same order.
		assertEquals(TEST_PROJECTION[0], cursor.getColumnName(0));
		assertEquals(TEST_PROJECTION[1], cursor.getColumnName(1));
		assertEquals(TEST_PROJECTION[2], cursor.getColumnName(2));
		assertEquals(TEST_PROJECTION[3], cursor.getColumnName(3));
	}

