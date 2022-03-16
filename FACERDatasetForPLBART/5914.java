	public void searchResults()
	{
		startActivityForResult(
			new Intent(this, SearchResultsActivity.class),
			R.id.mainactivity_menu_search_results
		);
	}

