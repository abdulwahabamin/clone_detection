    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //set paint style, Style.FILL will fill the color, Style.STROKE will stroke the color
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(getDimensionInPixel(0), getHeight() - (40 + random.nextInt((int) (getHeight() / 1.5f) - 25)), getDimensionInPixel(7), getHeight() - 15, paint);
        canvas.drawRect(getDimensionInPixel(10), getHeight() - (40 + random.nextInt((int) (getHeight() / 1.5f) - 25)), getDimensionInPixel(17), getHeight() - 15, paint);
        canvas.drawRect(getDimensionInPixel(20), getHeight() - (40 + random.nextInt((int) (getHeight() / 1.5f) - 25)), getDimensionInPixel(27), getHeight() - 15, paint);
    }

