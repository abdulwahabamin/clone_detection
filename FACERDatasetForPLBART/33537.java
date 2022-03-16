    /**
     * Displays a dialog allowing user to search new cities.
     */
    private void showAddCityDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddCityFragment addCityFragment = (AddCityFragment) fragmentManager
                .findFragmentByTag(ADD_CITY_FRAGMENT_TAG);
        if (addCityFragment == null) {
            addCityFragment = new AddCityFragment();
            addCityFragment.show(fragmentManager, ADD_CITY_FRAGMENT_TAG);
        }
    }

