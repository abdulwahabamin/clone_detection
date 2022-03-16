  /**
   * Renders the audio data onto a line. The line flashes on prominent beats
   * @param canvas
   * @param paint - Paint to draw lines with
   * @param paint - Paint to draw flash with
   * @param cycleColor - If true the color will change on each frame
   */
  public WaveformRenderer( Context context )
  {
    super();
    mContext = context;

    mBrightPaint = new Paint();
    mBrightPaint.setStrokeWidth(6f);
    mBrightPaint.setAntiAlias(true);
    mBrightPaint.setColor(Color.argb(188, 255, 255, 255));

    paintBrightBlur = new Paint();
    paintBrightBlur.set(mBrightPaint);
    paintBrightBlur.setColor(Color.argb(165, 0, 0, 0));
    paintBrightBlur.setStrokeWidth(6f);
    paintBrightBlur.setMaskFilter(new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL));
    
    mPaint = new Paint();
    mPaint.setStrokeWidth(2f);
    mPaint.setAntiAlias(true);
    mPaint.setColor(mContext.getResources().getColor(R.color.holo_blue_dark));
    
	paintBlur = new Paint();
	paintBlur.set(mPaint);
	paintBlur.setColor(Color.argb(165, 0, 0, 0));
	paintBlur.setStrokeWidth(2f);
	paintBlur.setMaskFilter(new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL));

  }

