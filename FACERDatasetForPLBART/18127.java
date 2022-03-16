	/**
	 * Use this constructor to animate an ImageView/ImageButton from one location to another and 
	 * change the image at the end of the animation.
	 */
	public TranslateAnimation(View view, long duration, int newImageResourceId, Interpolator interpolator, 
			                  int finalVisibility, int fromXType, float fromXValue, int toXType,
			                  float toXValue, int fromYType, float fromYValue,
			                  int toYType, float toYValue) {

		super(fromXType, fromXValue, toXType, 
		toXValue, fromYType, fromYValue, 
		toYType, toYValue);
		
		mChangeImageResource = true;
		mView = view;
		mDuration = duration;
		mFinalVisibility = finalVisibility;
		mNewImageResourceId = newImageResourceId;
		mInterpolator = interpolator;
		
	}

