	/** Inserts initial test data. */
	private void insertInitialTestData() {
		for (int index = 0; index < TEST_DATA.length; index++) {
			sqLiteDatabase.insertOrThrow(CityTable.TABLE_CITIES, null,
					TEST_DATA[index].getContentValues());
		}
	}

