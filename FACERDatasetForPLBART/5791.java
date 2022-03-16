	private Cursor getBookmarksCursor(){
		return managedQuery(BookmarksProvider.CONTENT_URI,
				new String[] {
					BookmarksProvider._ID,
					BookmarksProvider.NAME,
					BookmarksProvider.PATH,
					BookmarksProvider.CHECKED
				}, null, null, null);
	}

