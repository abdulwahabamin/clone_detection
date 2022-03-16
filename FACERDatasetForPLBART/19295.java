    /**
     * Sets the KitKat translucent status/nav bar and adjusts 
     * the views' boundaries.
     */
    private void setKitKatTranslucentBars() {
    	//KitKat translucent status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    		int statusBarHeight = Common.getStatusBarHeight(mContext);
            int navigationBarHeight = Common.getNavigationBarHeight(mContext);
            
            if (mDrawerParentLayout!=null) {
                mDrawerParentLayout.setClipToPadding(false);
                mDrawerParentLayout.setPadding(0, 0, 0, 0);
            }

            if (mControlsLayoutHeaderParent!=null) {
                int bottomPadding = mControlsLayoutHeaderParent.getPaddingBottom();
                mControlsLayoutHeaderParent.setClipToPadding(false);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mControlsLayoutHeaderParent.getLayoutParams();

                if (navigationBarHeight > 0) {
                    /* The nav bar already has padding, so remove the extra 15dp
                     * margin that was applied in the layout file.
                     */
                    params.bottomMargin = 0;
                }

                params.bottomMargin += navigationBarHeight;
                mControlsLayoutHeaderParent.setLayoutParams(params);

            }

        }
        
    }

