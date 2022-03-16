	/**
	 * Initializes the ActionBar.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        mMenu = menu;
        if (mCurrentFragmentId==Common.FOLDERS_FRAGMENT)
            showFolderFragmentActionItems(FilesFoldersFragment.currentDir,
                                          getMenuInflater(), menu, false);
        else
            showMainActivityActionItems(getMenuInflater(), menu);

		return super.onCreateOptionsMenu(menu);
	}

