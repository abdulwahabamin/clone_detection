	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)){
		case BOOKMARKS:
			count = db.update(
						TB_NAME, 
						values,
						selection, 
						selectionArgs);
			break;
		case BOOKMARK_ID:   
			count = db.update(
					TB_NAME, 
					values,
					_ID + " = " + uri.getPathSegments().get(0)
						+ (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""),
					selectionArgs);
			break;
		default: throw new IllegalArgumentException("Unknown URI " + uri);    
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

