    private void updateExtensionData() {
    	ExtensionData data = new ExtensionData();
    	
        //Publish the extension data update.
    	if (mApp.isServiceRunning()) {
    		//Show the extension with updated data.
    		try {
    			
    			status = "Playing";
    			expandedTitle = mApp.getService().getCurrentSong().getTitle();
    			expandedBody = mApp.getService().getCurrentSong().getAlbum() 
    						 + " - " 
    						 + mApp.getService().getCurrentSong().getArtist(); 
    			
    			Intent notificationIntent = new Intent(this, NowPlayingActivity.class);
    	        notificationIntent.putExtra("CALLED_FROM_FOOTER", true);
    	        notificationIntent.putExtra("CALLED_FROM_NOTIF", true);
    			
    			//Publish the extension data update.
    	        publishUpdate(data.visible(true)
        						  .icon(R.drawable.dashclock_icon)
        						  .status(status)
        						  .expandedTitle(expandedTitle)
        						  .expandedBody(expandedBody)
        						  .clickIntent(notificationIntent));
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    			//Hide the extension.
        		publishUpdate(data.visible(false));
    		}
    	} else {
    		//Hide the extension.
    		publishUpdate(data.visible(false));
    	}
    	 
    }

