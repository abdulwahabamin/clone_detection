	/**
	 * Resizes specific a Bitmap with keeping ratio.
	 */
	public static Bitmap resizeBitmap(Bitmap drawable, int desireWidth,
			int desireHeight) {
		int width = drawable.getWidth();
		int height = drawable.getHeight();

		if (0 < width && 0 < height && desireWidth < width
				|| desireHeight < height) {
			// Calculate scale
			float scale;
			if (width < height) {
				scale = (float) desireHeight / (float) height;
				if (desireWidth < width * scale) {
					scale = (float) desireWidth / (float) width;
				}
			} else {
				scale = (float) desireWidth / (float) width;
			}

			// Draw resized image
			Matrix matrix = new Matrix();
			matrix.postScale(scale, scale);
			Bitmap bitmap = Bitmap.createBitmap(drawable, 0, 0, width, height,
					matrix, true);
			Canvas canvas = new Canvas(bitmap);
			canvas.drawBitmap(bitmap, 0, 0, null);

			drawable = bitmap;
		}

		return drawable;
	}

