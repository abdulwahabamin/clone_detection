	public void setHomeLogo(int resId, OnClickListener onClickListener) {
		mLogoView.setImageResource(resId);
		mLogoView.setVisibility(View.VISIBLE);
		mLogoView.setOnClickListener(onClickListener);
		if (onClickListener != null) {
		}
	}

