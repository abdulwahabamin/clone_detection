    /**
     * This method should be called after all of the confetto's state variables are configured
     * and before the confetto gets animated.
     *
     * @param bound the space in which the confetto can display in.
     */
    public void prepare(Rect bound) {
        this.bound = bound;

        millisToReachTargetVelocityX = computeMillisToReachTarget(targetVelocityX,
                initialVelocityX, accelerationX);
        millisToReachTargetVelocityY = computeMillisToReachTarget(targetVelocityY,
                initialVelocityY, accelerationY);
        millisToReachTargetRotationalVelocity = computeMillisToReachTarget(targetRotationalVelocity,
                initialRotationalVelocity, rotationalAcceleration);

        // Compute how long it would take to reach x/y bounds or reach TTL.
        millisToReachBound = ttl >= 0 ? ttl : Long.MAX_VALUE;
        final long timeToReachXBound = computeBound(initialX, initialVelocityX, accelerationX,
                millisToReachTargetVelocityX, targetVelocityX,
                bound.left - getWidth(), bound.right);
        millisToReachBound = Math.min(timeToReachXBound, millisToReachBound);
        final long timeToReachYBound = computeBound(initialY, initialVelocityY, accelerationY,
                millisToReachTargetVelocityY, targetVelocityY,
                bound.top - getHeight(), bound.bottom);
        millisToReachBound = Math.min(timeToReachYBound, millisToReachBound);

        configurePaint(workPaint);
    }

