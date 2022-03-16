    /**
     * Scrolls the ViewPager programmatically. If dispatchToListener 
     * is true, USER_SCROLL will be set to true.
     */
    private void scrollViewPager(int newPosition, 
    							 boolean smoothScroll, 
    							 int velocity, 
    							 boolean dispatchToListener) {
    	
    	USER_SCROLL = dispatchToListener;
    	mViewPager.scrollToItem(newPosition, 
                                smoothScroll,
                                velocity,
                                dispatchToListener);
    	
    }

