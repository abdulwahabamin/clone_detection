	/**
	 * Set the currently selected page.
	 *
	 * @param item WeatherViewItem index to select
	 * @param smoothScroll True to smoothly scroll to the new item, false to activity_fade immediately
	 */
	public void setCurrentItem(int item, boolean smoothScroll) {
		setCurrentItemInternal(item, smoothScroll, false);
	}

