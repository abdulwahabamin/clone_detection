    /**
     * Reset this confetto object's internal states so that it can be re-used.
     */
    public void reset() {
        initialDelay = 0;
        initialX = initialY = 0f;
        initialVelocityX = initialVelocityY = 0f;
        accelerationX = accelerationY = 0f;
        targetVelocityX = targetVelocityY = null;
        millisToReachTargetVelocityX = millisToReachTargetVelocityY = null;

        initialRotation = 0f;
        initialRotationalVelocity = 0f;
        rotationalAcceleration = 0f;
        targetRotationalVelocity = null;
        millisToReachTargetRotationalVelocity = null;

        ttl = 0;
        millisToReachBound = 0f;
        percentageAnimated = 0f;
        fadeOutInterpolator = null;

        currentX = currentY = 0f;
        currentRotation = 0f;
        alpha = MAX_ALPHA;
        startedAnimation = false;
        terminated = false;
    }

