	@MediumTest
	public void testQueriesOnCityWeatherUri_queryRows() {
		insertInitialTestData();

		final String[] TEST_PROJECTION = { CityTable.COLUMN_CITY_ID,
				CityTable.COLUMN_NAME,
				CityTable.COLUMN_LAST_QUERY_TIME_FOR_CURRENT_WEATHER,
				CityTable.COLUMN_CACHED_JSON_CURRENT };
		final String ID_SELECTION = CityTable.COLUMN_CITY_ID + " = " + "?";
		final String TEST_SELECTION = ID_SELECTION + " OR " + ID_SELECTION
				+ " OR " + ID_SELECTION;
		final String[] SELECTION_ARGS = { "100", "400", "200" };
		final String SORT_ORDER = CityTable.COLUMN_CITY_ID + " ASC";

		Cursor cursor = mockContentResolver.query(
				WeatherContentProvider.CONTENT_URI_CITY_RECORDS,
				TEST_PROJECTION, TEST_SELECTION, SELECTION_ARGS, SORT_ORDER);
		int expectedRowCount = SELECTION_ARGS.length;
		int actualRowCount = cursor.getCount();

		assertEquals(
				"Passed "
						+ expectedRowCount
						+ " city Ids as selection arguments to the query, but the cursor has "
						+ actualRowCount + " rows", expectedRowCount,
				actualRowCount);

		String[] SELECTION_ARGS_SORTED = Arrays.copyOf(SELECTION_ARGS,
				SELECTION_ARGS.length);
		Arrays.sort(SELECTION_ARGS_SORTED);
		int CITY_ID_COLUMN_INDEX_IN_TEST_QUERY = 0;

		int cursorPosition = 0;
		while (cursor.moveToNext()) {
			String expectedCityId = SELECTION_ARGS_SORTED[cursorPosition];
			String actualCityId = cursor
					.getString(CITY_ID_COLUMN_INDEX_IN_TEST_QUERY);

			assertEquals("Incorrect city ID value at corsor position: "
					+ cursorPosition, expectedCityId, actualCityId);

			cursorPosition++;
		}

		int expectedTestedRowCount = SELECTION_ARGS_SORTED.length;
		int actualTestedRowCount = cursorPosition;
		assertEquals("Not all rows returned by the cursor were tested",
				expectedTestedRowCount, actualTestedRowCount);
	}

