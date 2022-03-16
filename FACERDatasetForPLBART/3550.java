        @SuppressWarnings("unchecked")
        public void onAnimationEnd(Animator animation) {
            animation.removeListener(this);
            mPlayingSet.remove(animation);
            Node animNode = mAnimatorSet.mNodeMap.get(animation);
            animNode.done = true;
            if (!mTerminated) {
                // Listeners are already notified of the AnimatorSet ending in cancel() or
                // end(); the logic below only kicks in when animations end normally
                ArrayList<Node> sortedNodes = mAnimatorSet.mSortedNodes;
                boolean allDone = true;
                int numSortedNodes = sortedNodes.size();
                for (int i = 0; i < numSortedNodes; ++i) {
                    if (!sortedNodes.get(i).done) {
                        allDone = false;
                        break;
                    }
                }
                if (allDone) {
                    // If this was the last child animation to end, then notify listeners that this
                    // AnimatorSet has ended
                    if (mListeners != null) {
                        ArrayList<AnimatorListener> tmpListeners =
                                (ArrayList<AnimatorListener>) mListeners.clone();
                        int numListeners = tmpListeners.size();
                        for (int i = 0; i < numListeners; ++i) {
                            tmpListeners.get(i).onAnimationEnd(mAnimatorSet);
                        }
                    }
                    mAnimatorSet.mStarted = false;
                }
            }
        }

