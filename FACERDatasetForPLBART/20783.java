        public void notifyFinalPositionExtended(int position) {
            mOver = 0;
            mFinished = false;
            mDuration = mDuration - (int) (mStartTime - AnimationUtils.currentAnimationTimeMillis());

            if (mDuration < 50) {
                mDuration = 50;
            }

            mSplineDuration = mDuration;

            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mStart = mCurrentPosition;
            mFinal = position;

            mState = SPLINE;

            mSplineDistance = mFinal - mStart;
        }

