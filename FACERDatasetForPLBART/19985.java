        @Override
        public void onStart() {
            mFirstChildHeight = -1;
            mSecondChildHeight = -1;
            mFirstPos = mFirstExpPos;
            mSecondPos = mSecondExpPos;
            srcPos = mSrcPos;
            mDragState = REMOVING;

            mFloatLocX = mFloatLoc.x;
            if (mUseRemoveVelocity) {
                float minVelocity = 2f * getWidth();
                if (mRemoveVelocityX == 0) {
                    mRemoveVelocityX = (mFloatLocX < 0 ? -1 : 1) * minVelocity;
                } else {
                    minVelocity *= 2;
                    if (mRemoveVelocityX < 0 && mRemoveVelocityX > -minVelocity)
                        mRemoveVelocityX = -minVelocity;
                    else if (mRemoveVelocityX > 0 && mRemoveVelocityX < minVelocity)
                        mRemoveVelocityX = minVelocity;
                }
            } else {
                destroyFloatView();
            }
        }

