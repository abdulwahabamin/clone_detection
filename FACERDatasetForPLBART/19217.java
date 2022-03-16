	/**
	 * ActionBar item selection listener.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
	    }
		
		switch (item.getItemId()) {
		case R.id.action_search:
			//ArtistsFragment.showSearch();
			return true;
	    case R.id.action_queue_drawer:
	    	if (mDrawerLayout!=null && mCurrentQueueDrawerLayout!=null) {
		    	if (mDrawerLayout.isDrawerOpen(mCurrentQueueDrawerLayout)) {
		    		mDrawerLayout.closeDrawer(mCurrentQueueDrawerLayout);
		    	} else {
		    		mDrawerLayout.openDrawer(mCurrentQueueDrawerLayout);
		    	}
		    	
	    	}
	    	return true;
        case R.id.action_up:
            ((FilesFoldersFragment) mCurrentFragment).getParentDir();
            return true;
        case R.id.action_paste:
            ((FilesFoldersFragment) mCurrentFragment).pasteIntoCurrentDir(((FilesFoldersFragment) mCurrentFragment).copyMoveSourceFile);
            showMainActivityActionItems(getMenuInflater(), getMenu());
            return true;
        case R.id.action_cancel:
            ((FilesFoldersFragment) mCurrentFragment).copyMoveSourceFile = null;
            if (((FilesFoldersFragment) mCurrentFragment).shouldMoveCopiedFile)
                Toast.makeText(mContext, R.string.move_canceled, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(mContext, R.string.copy_canceled, Toast.LENGTH_LONG).show();
            return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
		
	}

