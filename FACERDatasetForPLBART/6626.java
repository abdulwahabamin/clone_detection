	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		int count = 0;
		switch (uriMatcher.match(arg0)) {
		case BOOKMARKS:
			count = db.delete(TB_NAME, arg1, arg2);
			break;
		case BOOKMARK_ID:
			String id = arg0.getPathSegments().get(0);
			count = db.delete(TB_NAME, _ID + " = " + id
					+ (!TextUtils.isEmpty(arg1) ? " AND (" + arg1 + ')' : ""),
					arg2);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + arg0);
		}
		getContext().getContentResolver().notifyChange(arg0, null);
		return count;
	}

