    public boolean onTouchDown(MotionEvent event) {
        final float x = event.getX();
        final float y= event.getY();

        if (doesLocationIntercept(x, y)) {
            this.touchOverride = true;
            this.overrideX = x;
            this.overrideY = y;
            this.overrideDeltaX = currentX - x;
            this.overrideDeltaY = currentY - y;

            velocityTracker = VelocityTracker.obtain();
            velocityTracker.addMovement(event);

            return true;
        } else {
            return false;
        }
    }

