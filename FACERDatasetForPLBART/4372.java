    private void intialiseViewPager() {

        sMessageAdapter  = new SettingsHomeTabbedAdapter(activity.getSupportFragmentManager());
        //
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(sMessageAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

