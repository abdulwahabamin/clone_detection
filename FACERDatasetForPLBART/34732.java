    /**
     * 获�?�X方�?�的滑动速度,大于0�?��?�滑动，�??之�?�左
     *
     * @return
     */
    private int getScrollVelocity() {
        velocityTracker.computeCurrentVelocity(1000);
        int velocity = (int) velocityTracker.getXVelocity();
        return velocity;
    }

