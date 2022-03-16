    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = MATCHER.match(uri);
        switch (match) {
            case CACHEDIRECTORY:
                return DataCache.CONTENT_TYPE;
            case CACHEDIRECTORY_ID:
                return DataCache.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

