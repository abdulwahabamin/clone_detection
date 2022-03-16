    @Override
    public void draw(Canvas canvas) {
        long startDraw = System.currentTimeMillis();

        leftPauseBar.rewind();
        rightPauseBar.rewind();

        // move to center of canvas
        canvas.translate(getBounds().left, getBounds().top);

        float pauseBarHeight = 7.0F / 12.0F * ((float) getBounds().height());
        float pauseBarWidth = pauseBarHeight / 3.0F;
        float pauseBarDistance = pauseBarHeight / 3.6F;

        // The current distance between the two pause bars.
        final float barDist = interpolate(pauseBarDistance, 0.0F, progress);
        // The current width of each pause bar.
        final float barWidth = interpolate(pauseBarWidth, pauseBarHeight / 1.75F, progress);
        // The current position of the left pause bar's top left coordinate.
        final float firstBarTopLeft = interpolate(0.0F, barWidth, progress);
        // The current position of the right pause bar's top right coordinate.
        final float secondBarTopRight = interpolate(2.0F * barWidth + barDist, barWidth + barDist, progress);

        // Draw the left pause bar. The left pause bar transforms into the
        // top half of the play button triangle by animating the position of the
        // rectangle's top left coordinate and expanding its bottom width.
        leftPauseBar.moveTo(0.0F, 0.0F);
        leftPauseBar.lineTo(firstBarTopLeft, -pauseBarHeight);
        leftPauseBar.lineTo(barWidth, -pauseBarHeight);
        leftPauseBar.lineTo(barWidth, 0.0F);
        leftPauseBar.close();

        // Draw the right pause bar. The right pause bar transforms into the
        // bottom half of the play button triangle by animating the position of the
        // rectangle's top right coordinate and expanding its bottom width.
        rightPauseBar.moveTo(barWidth + barDist, 0.0F);
        rightPauseBar.lineTo(barWidth + barDist, -pauseBarHeight);
        rightPauseBar.lineTo(secondBarTopRight, -pauseBarHeight);
        rightPauseBar.lineTo(2.0F * barWidth + barDist, 0.0F);
        rightPauseBar.close();

        canvas.save();

        // Translate the play button a tiny bit to the right so it looks more centered.
        canvas.translate(interpolate(0.0F, pauseBarHeight / 8.0F, progress), 0.0F);

        // (1) Pause --> Play: rotate 0 to 90 degrees clockwise.
        // (2) Play --> Pause: rotate 90 to 180 degrees clockwise.
        final float rotationProgress = isPlay ? 1.0F - progress : progress;
        final float startingRotation = isPlay ? 90.0F : 0.0F;
        canvas.rotate(interpolate(startingRotation, startingRotation + 90.0F, rotationProgress), getBounds().width() / 2.0F, getBounds().height() / 2.0F);

        // Position the pause/play button in the center of the drawable's bounds.
        canvas.translate(getBounds().width() / 2.0F - ((2.0F * barWidth + barDist) / 2.0F), getBounds().height() / 2.0F + (pauseBarHeight / 2.0F));

        // Draw the two bars that form the animated pause/play button.
        canvas.drawPath(leftPauseBar, paint);
        canvas.drawPath(rightPauseBar, paint);

        canvas.restore();

        long timeElapsed = System.currentTimeMillis() - startDraw;
        if (timeElapsed > 16) {
            Log.e(TAG, "Drawing took too long=" + timeElapsed);
        }
    }

