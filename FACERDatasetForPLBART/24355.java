    private void enterSongsMode() {
        viewPager.setVisibility(View.GONE);

        ActionBar actionBar = getActionBar();
        saveActiveTab(actionBar);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        setTitle(title);

        mainView.setVisibility(View.VISIBLE);

        Fragment fragment;
        if (searchResult) {
            fragment = Fragment.instantiate(this, QueryFragment.class.getName());
            actionBar.setCustomView(null);
            actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_CUSTOM);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(TrackFragment.URI, uri.toString());
            fragment = Fragment.instantiate(this, TrackFragment.class.getName(), bundle);
            final WithSectionMenu trackFragment = (WithSectionMenu)fragment;

            categoryMenuView = new ImageView(this);
            categoryMenuView.setImageResource(R.drawable.ic_section_menu);
            categoryMenuView.setOnClickListener(v -> trackFragment.onCreateSectionMenu(categoryMenuView));
            actionBar.setCustomView(categoryMenuView);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM);
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.main, fragment, TrackFragment.class.getCanonicalName());
        ft.commit();
    }

