    @Override
    public String getType(Uri uri) {
        switch (myURIMatcher.match(uri)) {
            case CITIES_SINGLE_ROW:
                return CONTENT_ITEM_TYPE_CITY_RECORDS;
            case CITIES_ALL_ROWS:
                return CONTENT_TYPE_CITY_RECORDS;
            case CITIES_SEARCH:
                return SearchManager.SUGGEST_MIME_TYPE;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

