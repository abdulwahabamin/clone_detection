    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mIgnoreTouchEvent) {
            mIgnoreTouchEvent = false;
            return false;
        }

        if (!mDragEnabled) {
            return super.onTouchEvent(ev);
        }

        boolean more = false;

        boolean lastCallWasIntercept = mLastCallWasIntercept;
        mLastCallWasIntercept = false;

        if (!lastCallWasIntercept) {
            saveTouchCoords(ev);
        }

        // if (mFloatView != null) {
        if (mDragState == DRAGGING) {
            onDragTouchEvent(ev);
            more = true; // give us more!
        } else {
            // what if float view is null b/c we dropped in middle
            // of drag touch event?

            // if (mDragState != STOPPED) {
            if (mDragState == IDLE) {
                if (super.onTouchEvent(ev)) {
                    more = true;
                }
            }

            int action = ev.getAction() & MotionEvent.ACTION_MASK;

            switch (action) {
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    doActionUpOrCancel();
                    break;
                default:
                    if (more) {
                        mCancelMethod = ON_TOUCH_EVENT;
                    }
            }
        }

        return more;
    }

