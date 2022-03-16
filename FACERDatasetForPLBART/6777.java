	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_DELETE_BOOKMARKS:
			deleteBookmarksCursor = getBookmarksCursor();
			AlertDialog dialog = 
				new AlertDialog.Builder(this)
					.setTitle(R.string.bookmarks_select_to_delete)
	        		.setMultiChoiceItems(deleteBookmarksCursor,
        				BookmarksProvider.CHECKED, BookmarksProvider.NAME,
        				new DialogInterface.OnMultiChoiceClickListener() {
			        	    public void onClick(DialogInterface dialog, int item, boolean checked) {
			        	    	if (deleteBookmarksCursor.moveToPosition(item)) {
		        	    			Uri deleteUri = ContentUris.withAppendedId(
					        	    					BookmarksProvider.CONTENT_URI,
					        	    					deleteBookmarksCursor.getInt(
				        	    							deleteBookmarksCursor.getColumnIndex(
			        	    									BookmarksProvider._ID)));
		        	    			if(checked)
		        	    				bookmarksToDelete.add(deleteUri);
		        	    			else
		        	    				bookmarksToDelete.remove(deleteUri);
		        	    			

	        	    				((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE)
    									.setEnabled((bookmarksToDelete.size() > 0) ? true : false);
		        	    				
		        	    			ContentValues checkedValues = new ContentValues();
		        	    			checkedValues.put(BookmarksProvider.CHECKED, checked ? 1 : 0);
				        	    	getContentResolver().update(deleteUri, checkedValues, null, null);
				        	    	//Have to use the deprecated requery()
				        	    	//(see http://code.google.com/p/android/issues/detail?id=2998)
				        	    	deleteBookmarksCursor.requery();
			        	    	}
			        	    	((AlertDialog)dialog).getListView().invalidate();
			        	    }
		        	})
		        	.setPositiveButton(R.string.bookmarks_delete, new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							for(Uri uri : bookmarksToDelete){
			        	    	getContentResolver().delete(uri, null, null);
							}
		        	    	Toast.makeText(PreferenceActivity.this,
		        	    			R.string.bookmarks_deleted, Toast.LENGTH_SHORT).show();
		        			restartBookmarksChecked();
						}
					})
		        	.setNegativeButton(R.string.bookmarks_cancel, new DialogInterface.OnClickListener() {
		        	    public void onClick(DialogInterface dialog, int item) {
		        	    	restartBookmarksChecked();
		        	    }
		        	}).create();
			// TODO: need to fix
			/*	Commenting this out for now.  Need another way to do this or check for SDK > 7.
			 *  With this in, Android 1.5 crashes upon launch.
			dialog.setOnShowListener(new DialogInterface.OnShowListener() {
				@Override
				public void onShow(DialogInterface dialog) {
					((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
				}
			});*/
			return dialog;
		}
		return super.onCreateDialog(id);
	}

