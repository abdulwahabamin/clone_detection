    /**
	 * Sets this helper object as the current song. This method 
	 * will check if the song's album art has already been loaded. 
	 * If so, the updateNotification() and updateWidget() methods 
	 * will be called. If not, they'll be called as soon as the 
	 * album art is loaded.
	 */
	public void setIsCurrentSong() {
		mIsCurrentSong = true;
		//The album art has already been loaded.
		if (mIsAlbumArtLoaded) {
			mApp.getService().updateNotification(this);
			mApp.getService().updateWidgets();
		} else {
			/* 
			 * The album art isn't ready yet. The listener will call 
			 * the updateNotification() and updateWidgets() methods.
			 */
		}
		
	}

