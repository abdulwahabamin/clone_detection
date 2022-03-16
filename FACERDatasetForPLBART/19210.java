	/**
	 * Loads the specified fragment into the target layout.
	 */
	public void switchContent(Fragment fragment) {
        // Reset action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayShowCustomEnabled(false);

		getSupportFragmentManager().beginTransaction()
								   .replace(R.id.mainActivityContainer, fragment)
								   .commit();
		
		//Close the drawer(s).
		mDrawerLayout.closeDrawer(Gravity.START);
        invalidateOptionsMenu();

	}

