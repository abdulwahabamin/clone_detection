    /**
     * Sets the shuffle button icon based on the current shuffle mode.
     */
    private void setShuffleButtonIcon() {
    	if (mApp.isServiceRunning())
	        if (mApp.getService().isShuffleOn()==true) {
	        	mShuffleButton.setImageResource(R.drawable.shuffle_highlighted);
	        } else {
	        	mShuffleButton.setImageResource(UIElementsHelper.getIcon(mContext, "shuffle"));
	        }
    	
    	else
    		mShuffleButton.setImageResource(UIElementsHelper.getIcon(mContext, "shuffle"));
        
    }

