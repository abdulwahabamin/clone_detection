    private void startAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivSplashIcon, "translationY", 0, -(ivSplashIcon.getHeight() >> 1));
        animator.setDuration(800);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.setInterpolator(new CycleInterpolator(0.5f));
        animator.start();
    }

