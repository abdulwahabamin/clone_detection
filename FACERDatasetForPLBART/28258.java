	public void setAboveOffset(int i) {
		//		RelativeLayout.LayoutParams params = ((RelativeLayout.LayoutParams)mContent.getLayoutParams());
		//		params.setMargins(i, params.topMargin, params.rightMargin, params.bottomMargin);
		mContent.setPadding(i, mContent.getPaddingTop(), 
				mContent.getPaddingRight(), mContent.getPaddingBottom());
	}

