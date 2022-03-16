	@Override
	public void onPause() {
		super.onPause();
        //BLog.e("SET","pause called");


        //Bgo.removeFragmentFromFragmentManager(activity);
        State.addToState(State.SECTION_SETTINGS, new StateObject(StateObject.STRING_VALUE, mTabHost.getCurrentTabTag()));
        mTabHost.setOnTabChangedListener(null);
        mTabHost.getTabWidget().removeAllViews();
        mTabHost.clearAllTabs();
        mTabHost.setEnabled(false);
        mTabHost=null;

        mViewPager.removeAllViews();
        mViewPager.setOnPageChangeListener(null);
        mViewPager=null;

        sMessageAdapter.notifyDataSetChanged();
        sMessageAdapter=null;

        //tabInfo=null;
        mapTabInfo = new HashMap<String, TabInfo>();
        if(amb!=null)
            amb.done();
        //Bgo.removeFragmentFromFragmentManager(activity,SettingsGeneralFragment.class.getName());
        //Bgo.removeFragmentFromFragmentManager(activity,SettingsHomeTabbedFragment.class.getName());
        //outState.putString("tab", mTabHost.getCurrentTabTag());
	}

