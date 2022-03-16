    private void draw(Canvas canvas, float x, float y, float rotation, float percentageAnimated) {
        canvas.save();

        canvas.clipRect(bound);
        matrix.reset();
        workPaint.setAlpha(alpha);
        drawInternal(canvas, matrix, workPaint, x, y, rotation, percentageAnimated);

        canvas.restore();
    }

