    /**
     * èŽ·å?–Xæ–¹å?‘çš„æ»‘åŠ¨é€Ÿåº¦,å¤§äºŽ0å?‘å?³æ»‘åŠ¨ï¼Œå??ä¹‹å?‘å·¦
     *
     * @return
     */
    private int getScrollVelocity() {
        velocityTracker.computeCurrentVelocity(1000);
        int velocity = (int) velocityTracker.getXVelocity();
        return velocity;
    }

