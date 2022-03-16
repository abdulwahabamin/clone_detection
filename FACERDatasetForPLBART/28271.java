	@Override
	public void scrollTo(int x, int y) {
		super.scrollTo(x, y);
		mScrollX = x;
		mViewBehind.scrollBehindTo(mContent, x, y);	
		((SlidingMenu)getParent()).manageLayers(getPercentOpen());
	}

