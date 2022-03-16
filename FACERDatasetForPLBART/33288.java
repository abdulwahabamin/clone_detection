	@SmallTest
	public void testFragmentsAdded() {
		FragmentManager fragmentManager = mainActivity
				.getSupportFragmentManager();
		fragmentManager.executePendingTransactions();

		CityListFragmentWithWeatherButtons cityListFragment = (CityListFragmentWithWeatherButtons) fragmentManager
				.findFragmentById(com.haringeymobile.ukweather.R.id.city_list_container);
		assertNotNull(
				"City list fragment not found in the layout [city_list_container]",
				cityListFragment);

		cityListFragment = (CityListFragmentWithWeatherButtons) fragmentManager
				.findFragmentByTag(MainActivity.LIST_FRAGMENT_TAG);
		assertNotNull("City list fragment not found by tag "
				+ MainActivity.LIST_FRAGMENT_TAG, cityListFragment);

		WorkerFragmentToRetrieveJsonString workerFragment = (WorkerFragmentToRetrieveJsonString) fragmentManager
				.findFragmentByTag(MainActivity.WORKER_FRAGMENT_TAG);
		assertNotNull("Worker fragment not found by tag "
				+ MainActivity.WORKER_FRAGMENT_TAG, workerFragment);

		assertTrue("City list fragment not added", cityListFragment.isAdded());
		assertTrue("Worker fragment not added", workerFragment.isAdded());
	}

