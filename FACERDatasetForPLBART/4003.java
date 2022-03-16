        @Override
        public void onAnimationEnd(Animator animation) {
            if (mListener != null) {
                mListener.onAnimationEnd(animation);
            }
            mAnimatorMap.remove(animation);
            // If the map is empty, it means all animation are done or canceled, so the listener
            // isn't needed anymore. Not nulling it would cause it to leak any objects used in
            // its implementation
            if (mAnimatorMap.isEmpty()) {
                mListener = null;
            }
        }

