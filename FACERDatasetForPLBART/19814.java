	@Override
	protected void onDraw(Canvas canvas) {
		float radius = 5.0f; // angle of round corners
	    Path clipPath = new Path();
	    RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
	    clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
	    canvas.clipPath(clipPath);

	    super.onDraw(canvas);
	}

