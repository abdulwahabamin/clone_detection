        @Override
        public void run() {
            if (mAbort) {
                mScrolling = false;
                return;
            }

            final int first = getFirstVisiblePosition();
            final int last = getLastVisiblePosition();
            final int count = getCount();
            final int padTop = getPaddingTop();
            final int listHeight = getHeight() - padTop - getPaddingBottom();

            int minY = Math.min(mY, mFloatViewMid + mFloatViewHeightHalf);
            int maxY = Math.max(mY, mFloatViewMid - mFloatViewHeightHalf);

            if (scrollDir == UP) {
                View v = getChildAt(0);
                if (v == null) {
                    mScrolling = false;
                    return;
                } else {
                    if (first == 0 && v.getTop() == padTop) {
                        mScrolling = false;
                        return;
                    }
                }
                mScrollSpeed = mScrollProfile.getSpeed((mUpScrollStartYF - maxY)
                        / mDragUpScrollHeight, mPrevTime);
            } else {
                View v = getChildAt(last - first);
                if (v == null) {
                    mScrolling = false;
                    return;
                } else {
                    if (last == count - 1 && v.getBottom() <= listHeight + padTop) {
                        mScrolling = false;
                        return;
                    }
                }
                mScrollSpeed = -mScrollProfile.getSpeed((minY - mDownScrollStartYF)
                        / mDragDownScrollHeight, mPrevTime);
            }

            mCurrTime = SystemClock.uptimeMillis();
            dt = (float) (mCurrTime - mPrevTime);

            // dy is change in View position of a list item; i.e. positive dy
            // means user is scrolling up (list item moves down the screen,
            // remember
            // y=0 is at top of View).
            dy = (int) Math.round(mScrollSpeed * dt);

            int movePos;
            if (dy >= 0) {
                dy = Math.min(listHeight, dy);
                movePos = first;
            } else {
                dy = Math.max(-listHeight, dy);
                movePos = last;
            }

            final View moveItem = getChildAt(movePos - first);
            int top = moveItem.getTop() + dy;

            if (movePos == 0 && top > padTop) {
                top = padTop;
            }

            // always do scroll
            mBlockLayoutRequests = true;

            setSelectionFromTop(movePos, top - padTop);
            DragSortListView.this.layoutChildren();
            invalidate();

            mBlockLayoutRequests = false;

            // scroll means relative float View movement
            doDragFloatView(movePos, moveItem, false);

            mPrevTime = mCurrTime;

            post(this);
        }

