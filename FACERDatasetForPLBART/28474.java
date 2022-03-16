    /**
     * Update the confetto internal state based on the provided passed time.
     *
     * @param passedTime time since the beginning of the animation.
     * @return whether this particular confetto is still animating.
     */
    public boolean applyUpdate(long passedTime) {
        if (initialDelay == RESET_ANIMATION_INITIAL_DELAY) {
            initialDelay = passedTime;
        }

        final long animatedTime = passedTime - initialDelay;
        startedAnimation = animatedTime >= 0;

        if (startedAnimation && !terminated) {
            currentX = computeDistance(animatedTime, initialX, initialVelocityX, accelerationX,
                    millisToReachTargetVelocityX, targetVelocityX);
            currentY = computeDistance(animatedTime, initialY, initialVelocityY, accelerationY,
                    millisToReachTargetVelocityY, targetVelocityY);
            currentRotation = computeDistance(animatedTime, initialRotation,
                    initialRotationalVelocity, rotationalAcceleration,
                    millisToReachTargetRotationalVelocity, targetRotationalVelocity);

            if (fadeOutInterpolator != null) {
                final float interpolatedTime =
                        fadeOutInterpolator.getInterpolation(animatedTime / millisToReachBound);
                alpha = (int) (interpolatedTime * MAX_ALPHA);
            } else {
                alpha = MAX_ALPHA;
            }

            terminated = !touchOverride && animatedTime >= millisToReachBound;
            percentageAnimated = Math.min(1f, animatedTime / millisToReachBound);
        }

        return !terminated;
    }

