    public void refresh() {
        amb= new ActionModeBack(activity, activity.getResources().getString(R.string.action_settings)
                ,R.menu.settings
                , new ActionModeCallback() {
            @Override
            public void onActionMenuItem(ActionMode mode, MenuItem item) {
                //Log.e("AMB", "menuitem actionmodeback: " + mode);
                Bgo.goPreviousFragment(activity);
            }
        });
        if(android.os.Build.VERSION.SDK_INT>= 19) {

            ActionBarManager.setActionBarBackV19((AppCompatActivity) activity, amb);
            //setActionBarBackV19();
        } else {
            ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.action_settings), R.menu.archive,amb);
        }
    	//BriefManager.clearController(activity);
		//ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.action_settings),R.menu.settings);
        //BLog.e("RESUME", "Settings refresh");
        initialiseTabHost();
        intialiseViewPager();
        if (State.hasStateObject(State.SECTION_SETTINGS, StateObject.STRING_VALUE)) {
            //BLog.e("SETTAG",""+State.getStateObjectString(State.SECTION_SETTINGS,StateObject.STRING_VALUE));
            mTabHost.setCurrentTabByTag(State.getStateObjectString(State.SECTION_SETTINGS, StateObject.STRING_VALUE));
        }
        //if (savedInstanceState != null) {
        //    mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        //}

    }

