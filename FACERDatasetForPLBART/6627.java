	@Override
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)){
		case BOOKMARKS:
			return BOOKMARKS_MIMETYPE;
		case BOOKMARK_ID:                
			return BOOKMARK_MIMETYPE;
		default:
			throw new IllegalArgumentException("Unsupported URI: " + uri);        
		}   
	}

