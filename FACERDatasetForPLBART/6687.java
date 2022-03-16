	private Cursor getBookmarks(){
		return managedQuery(BookmarksProvider.CONTENT_URI,
					new String[] {
						BookmarksProvider._ID,
						BookmarksProvider.NAME,
						BookmarksProvider.PATH,
					}, null, null, null);
	}

