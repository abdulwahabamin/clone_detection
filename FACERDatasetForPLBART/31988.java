    public void deleteRecordFromTable(Integer recordId) {
        SQLiteDatabase db = getWritableDatabase();
        String selection = ReverseGeocodingCacheContract.LocationAddressCache._ID + " = ?";
        String[] selectionArgs = { recordId.toString() };
        db.delete(ReverseGeocodingCacheContract.LocationAddressCache.TABLE_NAME, selection, selectionArgs);
    }

