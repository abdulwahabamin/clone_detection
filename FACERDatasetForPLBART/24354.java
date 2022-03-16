    private void enterCategoryMode() {
        uri = null;
        title = null;

        Fragment oldFragment = getFragmentManager().findFragmentByTag(TrackFragment.class.getCanonicalName());
        if (oldFragment != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.remove(oldFragment);
            ft.commit();
        }
        mainView.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        setTitle(null);
        actionBar.setCustomView(null);
        actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_CUSTOM);

        viewPager.setVisibility(View.VISIBLE);

        restoreActiveTab(actionBar);
    }

