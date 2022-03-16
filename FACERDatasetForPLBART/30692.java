    public void selectFragmentForMenuItemId(@IdRes int itemId) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment;

        switch (itemId) {

            case R.id.action_search:
                fragment = CityWeatherSearchFragment.newInstance();
                break;
            case R.id.action_favorites:
                fragment = CityWeatherFavoriteFragment.newInstance();
                break;
            case R.id.action_nearby:
                // TODO: Implement this feature
                fragment = CityWeatherSearchFragment.newInstance();
                Toast.makeText(this, "This feature is not yet implemented", Toast.LENGTH_SHORT).show();
                break;
            default:
                fragment = CityWeatherSearchFragment.newInstance();
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.bottom_bar_fragment_container,
                fragment, BOTTOM_BAR_TAG).commit();
    }

