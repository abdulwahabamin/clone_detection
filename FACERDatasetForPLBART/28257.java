	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		try {
			final int width = r - l;
			final int height = b - t;
			mContent.layout(0, 0, width, height);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

