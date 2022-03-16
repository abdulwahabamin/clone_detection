	public FadeAnimation(View view, long duration, float fromAlpha, 
						 float toAlpha, Interpolator interpolator) {
		
		super(fromAlpha, toAlpha);
		mView = view;
		mDuration = duration;
		mFromAlpha = fromAlpha;
		mToAlpha = toAlpha;
		mInterpolator = interpolator;
		
	}

