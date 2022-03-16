    /** (non-Javadoc)
     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
     */
    public void onTabChanged(String tag) {
        int position = mTabHost.getCurrentTab();
        mViewPager.setCurrentItem(position);

    }

