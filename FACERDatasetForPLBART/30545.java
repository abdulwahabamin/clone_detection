    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initDefValue();
        initPaint();
        if (hourlyWeatherList != null && hourlyWeatherList.size() != 0) {
            drawLines(canvas);
            drawBitmaps(canvas);
            drawTemp(canvas);
        }
    }

