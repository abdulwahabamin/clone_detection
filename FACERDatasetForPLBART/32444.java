        @Override
        public void run() {
            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            String[] projection = {
                    LocationAddressCache.COLUMN_NAME_CREATED,
                    LocationAddressCache._ID
            };

            Cursor cursor = null;
            try {
                cursor = db.query(
                    LocationAddressCache.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null
                );

                while (cursor.moveToNext()) {
                    Integer recordId = cursor.getInt(
                            cursor.getColumnIndexOrThrow(LocationAddressCache._ID));

                    long recordCreatedInMilis = cursor.getLong(
                            cursor.getColumnIndexOrThrow(LocationAddressCache.COLUMN_NAME_CREATED));

                    if (recordDateIsNotValidOrIsTooOld(recordCreatedInMilis)) {
                        mDbHelper.deleteRecordFromTable(recordId);
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

