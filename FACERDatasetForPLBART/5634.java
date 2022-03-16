	@Override
	public Uri insert(Uri uri, ContentValues values){
		long rowID = db.insert(TB_NAME, "", values);
		if (rowID > 0){
			Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(_uri, null);    
			return _uri;                
		}
		throw new SQLException("Failed to insert row into " + uri);
	}

