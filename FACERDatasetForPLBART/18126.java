	/**
	 * Use this constructor to animate a view from one location to another.
	 */
	public TranslateAnimation(View view, long duration, Interpolator interpolator, 
							  int finalVisibility, int fromXType, float fromXValue, int toXType,
							  float toXValue, int fromYType, float fromYValue, 
							  int toYType, float toYValue) {
		
		super(fromXType, fromXValue, toXType, 
			  toXValue, fromYType, fromYValue, 
			  toYType, toYValue);
		
		mView = view;
		mDuration = duration;
		mFinalVisibility = finalVisibility;
		mInterpolator = interpolator;
		
	}

