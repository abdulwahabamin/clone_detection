	/**
	 * Performs the fade animation.
	 */
	public void animate() {
		
		if (mView==null)
			return;
		
		if (mFromAlpha==mToAlpha)
			return;
		
		if (mDuration==0)
			return;
		
		//Set the animation parameters.
		if (mFromAlpha > mToAlpha)
			//Fade out animation.
			this.setAnimationListener(fadeOutListener);
		else
			//Fade in animation.
			this.setAnimationListener(fadeInListener);
		
		this.setDuration(mDuration);
        if (mInterpolator!=null)
		    this.setInterpolator(mInterpolator);
		mView.startAnimation(this);

	}

