    @Override
    public void onPageSelected(int position) {
        // TODO Auto-generated method stub
    	synchronized(this) {
    		mTabHost.setCurrentTab(position);

    	}
    }

