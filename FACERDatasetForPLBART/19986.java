        @Override
        public void onUpdate(float frac, float smoothFrac) {
            float f = 1f - smoothFrac;

            final int firstVis = getFirstVisiblePosition();
            View item = getChildAt(mFirstPos - firstVis);
            ViewGroup.LayoutParams lp;
            int blank;

            if (mUseRemoveVelocity) {
                float dt = (float) (SystemClock.uptimeMillis() - mStartTime) / 1000;
                if (dt == 0)
                    return;
                float dx = mRemoveVelocityX * dt;
                int w = getWidth();
                mRemoveVelocityX += (mRemoveVelocityX > 0 ? 1 : -1) * dt * w;
                mFloatLocX += dx;
                mFloatLoc.x = (int) mFloatLocX;
                if (mFloatLocX < w && mFloatLocX > -w) {
                    mStartTime = SystemClock.uptimeMillis();
                    doDragFloatView(true);
                    return;
                }
            }

            if (item != null) {
                if (mFirstChildHeight == -1) {
                    mFirstChildHeight = getChildHeight(mFirstPos, item, false);
                    mFirstStartBlank = (float) (item.getHeight() - mFirstChildHeight);
                }
                blank = Math.max((int) (f * mFirstStartBlank), 1);
                lp = item.getLayoutParams();
                lp.height = mFirstChildHeight + blank;
                item.setLayoutParams(lp);
            }
            if (mSecondPos != mFirstPos) {
                item = getChildAt(mSecondPos - firstVis);
                if (item != null) {
                    if (mSecondChildHeight == -1) {
                        mSecondChildHeight = getChildHeight(mSecondPos, item, false);
                        mSecondStartBlank = (float) (item.getHeight() - mSecondChildHeight);
                    }
                    blank = Math.max((int) (f * mSecondStartBlank), 1);
                    lp = item.getLayoutParams();
                    lp.height = mSecondChildHeight + blank;
                    item.setLayoutParams(lp);
                }
            }
        }

