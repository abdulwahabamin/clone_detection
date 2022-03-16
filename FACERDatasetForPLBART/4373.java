    /**
     * Initialise the Tab Host
     */
    private void initialiseTabHost() {
        //BLog.e("SETTAG","INIT TAB HOST");
        mTabHost = (TabHost)view.findViewById(android.R.id.tabhost);

        mTabHost.setup();
        mTabHost.clearAllTabs();
        mTabHost.setEnabled(true);
        TabInfo tabInfo = null;
        //BriefMessage.
//        SpannableString briefStr= B.getStyledWithTypeFaceName(activity, activity.getResources().getString(R.string.title_brief), State.getSettings().getString(BriefSettings.STRING_THEME),1f);
        SettingsHomeTabbedFragment.AddTab(this, this.mTabHost, mTabHost.newTabSpec(activity.getResources().getString(R.string.settings_tab1)).setIndicator(activity.getResources().getString(R.string.settings_tab1)), (tabInfo = new TabInfo(activity.getResources().getString(R.string.settings_tab1), SettingsAboutFragment.class, new Bundle())));
        mapTabInfo.put(tabInfo.tag, tabInfo);
        SettingsHomeTabbedFragment.AddTab(this, this.mTabHost, mTabHost.newTabSpec(activity.getResources().getString(R.string.settings_tab2)).setIndicator(activity.getResources().getString(R.string.settings_tab2)), (tabInfo = new TabInfo(activity.getResources().getString(R.string.settings_tab2), SettingsGeneralFragment.class, new Bundle())));
        mapTabInfo.put(tabInfo.tag, tabInfo);
        SettingsHomeTabbedFragment.AddTab(this, this.mTabHost, mTabHost.newTabSpec(activity.getResources().getString(R.string.settings_tab3)).setIndicator(activity.getResources().getString(R.string.settings_tab3)), (tabInfo = new TabInfo(activity.getResources().getString(R.string.settings_tab3), SettingsAboutFragment.class, new Bundle())));
        mapTabInfo.put(tabInfo.tag, tabInfo);

        mTabHost.getTabWidget().getChildAt(0).setBackground(activity.getResources().getDrawable(R.drawable.tab_bg_selector));
        mTabHost.getTabWidget().getChildAt(1).setBackground(activity.getResources().getDrawable(R.drawable.tab_bg_selector));
        mTabHost.getTabWidget().getChildAt(2).setBackground(activity.getResources().getDrawable(R.drawable.tab_bg_selector));
        mTabHost.getTabWidget().setDividerDrawable(R.drawable.tab_bg_divider);

        //TextView x2 = (TextView) mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        //TextView x3 = (TextView) mTabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);

        mTabHost.setOnTabChangedListener(this);
    }

