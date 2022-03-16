        private int getTargetY() {
            final int first = getFirstVisiblePosition();
            final int otherAdjust = (mItemHeightCollapsed + getDividerHeight()) / 2;
            View v = getChildAt(mDropPos - first);
            int targetY = -1;
            if (v != null) {
                if (mDropPos == srcPos) {
                    targetY = v.getTop();
                } else if (mDropPos < srcPos) {
                    // expanded down
                    targetY = v.getTop() - otherAdjust;
                } else {
                    // expanded up
                    targetY = v.getBottom() + otherAdjust - mFloatViewHeight;
                }
            } else {
                // drop position is not on screen?? no animation
                cancel();
            }

            return targetY;
        }

