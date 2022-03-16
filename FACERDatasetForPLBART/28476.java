    /**
     * Primary method for rendering this confetto on the canvas.
     *
     * @param canvas the canvas to draw on.
     */
    public void draw(Canvas canvas) {
        if (touchOverride) {
            draw(canvas, overrideX + overrideDeltaX, overrideY + overrideDeltaY, currentRotation,
                    percentageAnimated);
        } else if (startedAnimation && !terminated) {
            draw(canvas, currentX ,currentY, currentRotation, percentageAnimated);
        }
    }

