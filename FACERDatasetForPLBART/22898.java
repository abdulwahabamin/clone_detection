    private void toggle() {
        if (animator != null) {
            animator.cancel();
        }

        animator = ObjectAnimator.ofFloat(this, PROGRESS, isPlay ? 1.0F : 0.0F, isPlay ? 0.0F : 1.0F);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                isPlay = !isPlay;
            }
        });

        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(200);
        animator.start();
    }

