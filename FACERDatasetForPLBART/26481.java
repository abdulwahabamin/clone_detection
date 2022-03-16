    @SuppressWarnings("deprecation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);

        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / INITIAL.length;
        for (int i = 0; i < INITIAL.length; i++) {
            paint.setTextSize(getResources().getDimension(R.dimen.text_size_small));
            paint.setColor(getResources().getColor(R.color.colorAccent));
            paint.setAntiAlias(true);
            float xPos = width / 2 - paint.measureText(INITIAL[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            canvas.drawText(INITIAL[i], xPos, yPos, paint);
            paint.reset();
        }

    }

