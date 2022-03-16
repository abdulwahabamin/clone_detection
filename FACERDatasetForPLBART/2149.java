    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(DataCache.AUTHORITY, DataCache.TABLE_NAME, CACHEDIRECTORY);
        matcher.addURI(DataCache.AUTHORITY, DataCache.TABLE_NAME + "/#", CACHEDIRECTORY_ID);
        return matcher;
    }

