    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (gestureDetector.onTouchEvent(event) && !animationRunning)
        {
            if (hasToZoom)
                this.startAnimation(scaleAnimation);

            radiusMax = Math.max(WIDTH, HEIGHT);

            if (rippleType != 2)
                radiusMax /= 2;

            radiusMax -= ripplePadding;

            if (isCentered || rippleType == 1)
            {
                this.x = getMeasuredWidth() / 2;
                this.y = getMeasuredHeight() / 2;
            }
            else
            {
                this.x = event.getX();
                this.y = event.getY();
            }

            animationRunning = true;

            if (rippleType == 1 && originBitmap == null)
                originBitmap = getDrawingCache(true);

            invalidate();
        }

        childView.onTouchEvent(event);
        return true;
    }

