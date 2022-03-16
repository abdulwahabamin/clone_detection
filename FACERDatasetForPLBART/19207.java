	/**
	 * Apply KitKat specific translucency.
	 */
	private void applyKitKatTranslucency() {
		
		//KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

        	//Set the window background.
        	getWindow().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
        	
    		int topPadding = Common.getStatusBarHeight(mContext);
    		if (mDrawerLayout!=null) {
    			mDrawerLayout.setPadding(0, topPadding, 0, 0);
    			mNavDrawerLayout.setPadding(0, topPadding, 0, 0);
    			mCurrentQueueDrawerLayout.setPadding(0, topPadding, 0, 0);
    		}

            //Calculate ActionBar and navigation bar height.
            TypedValue tv = new TypedValue();
            int actionBarHeight = 0;
            if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            }

            if (mDrawerParentLayout!=null) {
            	mDrawerParentLayout.setPadding(0, actionBarHeight, 0, 0);
            	mDrawerParentLayout.setClipToPadding(false);
            }
            
        }
        
	}

