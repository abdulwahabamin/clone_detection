	/**
	 * Adds ActionIcons to the ActionBar (adds to the left-end)
	 * 
	 * @param iconResourceId
	 * @param onClickListener to handle click actions on the ActionIcon.
	 */
	public void addActionIcon(int iconResourceId, OnClickListener onClickListener) {
		// Inflate
		View view = mInflater.inflate(R.layout.actionbar_icon, mActionIconContainer, false);
		ImageButton imgButton = (ImageButton) view.findViewById(R.id.actionbar_item);
		imgButton.setImageResource(iconResourceId);
		imgButton.setOnClickListener(onClickListener);

		mActionIconContainer.addView(view, mActionIconContainer.getChildCount());
	}

