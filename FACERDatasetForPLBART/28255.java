	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		try {
			int width = getDefaultSize(0, widthMeasureSpec);
			int height = getDefaultSize(0, heightMeasureSpec);
			setMeasuredDimension(width, height);

			final int contentWidth = getChildMeasureSpec(widthMeasureSpec, 0, width);
			final int contentHeight = getChildMeasureSpec(heightMeasureSpec, 0, height);
			mContent.measure(contentWidth, contentHeight);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

