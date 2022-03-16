	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
		sqlBuilder.setTables(TB_NAME);
		if (uriMatcher.match(uri) == BOOKMARK_ID){
			sqlBuilder.appendWhere(_ID + " = " + uri.getPathSegments().get(0));  
		}
		
		if (sortOrder==null || sortOrder=="")
			sortOrder = _ID;
		
		Cursor c = sqlBuilder.query(db, 
									projection, 
									selection, 
									selectionArgs, 
									null, 
									null, 
									sortOrder);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

