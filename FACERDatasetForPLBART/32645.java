        private String getDataFromCacheDB() {

            ReverseGeocodingCacheDbHelper mDbHelper = ReverseGeocodingCacheDbHelper.getInstance(getActivity());
            SQLiteDatabase db = mDbHelper.getReadableDatabase();
            long numberOfRowsInAddress = DatabaseUtils.queryNumEntries(db, ReverseGeocodingCacheContract.LocationAddressCache.TABLE_NAME);

            StringBuilder lastRowsFromDB = new StringBuilder();

            lastRowsFromDB.append("There are ");
            lastRowsFromDB.append(numberOfRowsInAddress);
            lastRowsFromDB.append(" of rows in cache.\n\n");

            String[] projection = {
                    ReverseGeocodingCacheContract.LocationAddressCache.COLUMN_NAME_ADDRESS,
                    ReverseGeocodingCacheContract.LocationAddressCache.COLUMN_NAME_CREATED,
                    ReverseGeocodingCacheContract.LocationAddressCache._ID
            };

            String sortOrder = ReverseGeocodingCacheContract.LocationAddressCache.COLUMN_NAME_CREATED + " DESC";

            Cursor cursor = db.query(
                    ReverseGeocodingCacheContract.LocationAddressCache.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    sortOrder
            );

            int rowsCounter = 0;

            while(cursor.moveToNext()) {

                if (!cursor.isFirst()) {
                    lastRowsFromDB.append("\n");
                }

                byte[] cachedAddressBytes = cursor.getBlob(
                        cursor.getColumnIndexOrThrow(ReverseGeocodingCacheContract.LocationAddressCache.COLUMN_NAME_ADDRESS));
                Address address = ReverseGeocodingCacheDbHelper.getAddressFromBytes(cachedAddressBytes);

                long recordCreatedinMilis = cursor.getLong(cursor.getColumnIndexOrThrow(ReverseGeocodingCacheContract.LocationAddressCache.COLUMN_NAME_CREATED));
                String recordCreatedTxt = iso8601Format.format(new Date(recordCreatedinMilis));

                int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(ReverseGeocodingCacheContract.LocationAddressCache._ID));

                lastRowsFromDB.append(itemId);
                lastRowsFromDB.append(" : ");
                lastRowsFromDB.append(recordCreatedTxt);
                lastRowsFromDB.append(" : ");
                if (address.getLocality() != null) {
                    lastRowsFromDB.append(address.getLocality());
                    if (!address.getLocality().equals(address.getSubLocality())) {
                        lastRowsFromDB.append(" - ");
                        lastRowsFromDB.append(address.getSubLocality());
                    }
                }

                rowsCounter++;
                if (rowsCounter > 7) {
                    break;
                }
            }
            cursor.close();

            return lastRowsFromDB.toString();
        }

