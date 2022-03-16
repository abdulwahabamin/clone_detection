    public void onTouchUp(MotionEvent event) {
        velocityTracker.addMovement(event);
        velocityTracker.computeCurrentVelocity(1);

        this.initialDelay = RESET_ANIMATION_INITIAL_DELAY;
        this.initialX = event.getX() + overrideDeltaX;
        this.initialY = event.getY() + overrideDeltaY;
        this.initialVelocityX = velocityTracker.getXVelocity();
        this.initialVelocityY = velocityTracker.getYVelocity();
        this.initialRotation = currentRotation;

        velocityTracker.recycle();
        prepare(bound);
        this.touchOverride = false;
    }

