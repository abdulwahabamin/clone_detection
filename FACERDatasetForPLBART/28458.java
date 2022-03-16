    private void startNewAnimation() {
        // Never-ending animator, we will cancel once the termination condition is reached.
        animator = ValueAnimator.ofInt(0)
                .setDuration(Long.MAX_VALUE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                final long elapsedTime = valueAnimator.getCurrentPlayTime();
                processNewEmission(elapsedTime);
                updateConfetti(elapsedTime);

                if (confetti.size() == 0 && elapsedTime >= emissionDuration) {
                    terminate();
                } else {
                    confettiView.invalidate();
                }
            }
        });

        animator.start();
    }

