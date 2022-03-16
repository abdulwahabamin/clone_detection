    /**
     * @deprecated
     * Applies the correct transformer effect to the ViewPager.
     */
   @Deprecated
	private void setPlaylistPagerAnimation() {
    	if (mApp.getSharedPreferences().getInt("TRACK_CHANGE_ANIMATION", 0)==0) {
            mViewPager.setPageTransformer(true, new ZoomOutPageTransformer(0.85f));
    	} else if (mApp.getSharedPreferences().getInt("TRACK_CHANGE_ANIMATION", 0)==1) {
    		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer(0.85f));
    	} else if (mApp.getSharedPreferences().getInt("TRACK_CHANGE_ANIMATION", 0)==2) {
            mViewPager.setPageTransformer(true, new ZoomOutPageTransformer(0.85f));
    	}

    }

