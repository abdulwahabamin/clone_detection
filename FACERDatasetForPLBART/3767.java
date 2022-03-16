    @Override
    public void cancel() {
        // Only cancel if the animation is actually running or has been started and is about
        // to run
        if (mPlayingState != STOPPED || sPendingAnimations.get().contains(this) ||
                sDelayedAnims.get().contains(this)) {
            // Only notify listeners if the animator has actually started
            if (mRunning && mListeners != null) {
                ArrayList<AnimatorListener> tmpListeners =
                        (ArrayList<AnimatorListener>) mListeners.clone();
                for (AnimatorListener listener : tmpListeners) {
                    listener.onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

