	private void restartBookmarksChecked(){
		ContentValues checkedValues = new ContentValues();
		checkedValues.put(BookmarksProvider.CHECKED, 0);
    	getContentResolver().update(BookmarksProvider.CONTENT_URI, checkedValues, null, null);
    	deleteBookmarksCursor.requery();
    	bookmarksToDelete.clear();
	}

