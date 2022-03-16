	/**
	 * Performs the fade animation.
	 */
	public void animate() {
		
		if (mView==null)
			return;
		
		if (mDuration==0)
			return;

		//Set the animation parameters.
		this.setAnimationListener(translateListener);
		this.setDuration(mDuration);
		this.setInterpolator(mInterpolator);
		mView.startAnimation(this);

	}

