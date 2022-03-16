        @Override
        public void onStart() {
            mDropPos = mFloatPos;
            srcPos = mSrcPos;
            mDragState = DROPPING;
            mInitDeltaY = mFloatLoc.y - getTargetY();
            mInitDeltaX = mFloatLoc.x - getPaddingLeft();
        }

