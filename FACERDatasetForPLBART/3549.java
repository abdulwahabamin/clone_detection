        public void onAnimationCancel(Animator animation) {
            if (!mTerminated) {
                // Listeners are already notified of the AnimatorSet canceling in cancel().
                // The logic below only kicks in when animations end normally
                if (mPlayingSet.size() == 0) {
                    if (mListeners != null) {
                        int numListeners = mListeners.size();
                        for (int i = 0; i < numListeners; ++i) {
                            mListeners.get(i).onAnimationCancel(mAnimatorSet);
                        }
                    }
                }
            }
        }

