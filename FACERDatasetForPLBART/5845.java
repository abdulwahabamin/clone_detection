	/**
	 * Resizes specific a Drawable with keeping ratio.
	 */
	public static Drawable resizeDrawable(Drawable drawable, int desireWidth,
			int desireHeight) {
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();

		if (0 < width && 0 < height && desireWidth < width
				|| desireHeight < height) {
			drawable = new BitmapDrawable(resizeBitmap(
					((BitmapDrawable) drawable).getBitmap(), desireWidth,
					desireHeight));
		}

		return drawable;
	}

