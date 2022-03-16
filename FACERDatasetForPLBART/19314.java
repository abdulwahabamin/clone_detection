    /**
     * Smoothly scrolls the seekbar to the indicated position.
     */
    private void smoothScrollSeekbar(int progress) {
        ObjectAnimator animation = ObjectAnimator.ofInt(mSeekbar, "progress", progress);
        animation.setDuration(200);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

    }

