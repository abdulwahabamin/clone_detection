    /**
     * Sets the repeat button icon based on the current repeat mode.
     */
    private void setRepeatButtonIcon() {
    	if (mApp.isServiceRunning())
	    	if (mApp.getService().getRepeatMode()==Common.REPEAT_OFF) {
	    		mRepeatButton.setImageResource(UIElementsHelper.getIcon(mContext, "repeat"));
	    	} else if (mApp.getService().getRepeatMode()==Common.REPEAT_PLAYLIST) {
	    		mRepeatButton.setImageResource(R.drawable.repeat_highlighted);
	    	} else if (mApp.getService().getRepeatMode()==Common.REPEAT_SONG) {
	    		mRepeatButton.setImageResource(R.drawable.repeat_song);
	    	} else if (mApp.getService().getRepeatMode()==Common.A_B_REPEAT) {
	    		mRepeatButton.setImageResource(R.drawable.repeat_song_range);
	    	}
    	
	    else
	    	mRepeatButton.setImageResource(UIElementsHelper.getIcon(mContext, "repeat"));
    	
    }

