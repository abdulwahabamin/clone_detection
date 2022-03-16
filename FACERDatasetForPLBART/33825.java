    private void saveTouchCoords(MotionEvent ev) {
        int action = ev.getAction() & MotionEvent.ACTION_MASK;
        if (action != MotionEvent.ACTION_DOWN) {
            //mLastX = mX;
            mLastY = mY;
        }
        mX = (int) ev.getX();
        mY = (int) ev.getY();
        if (action == MotionEvent.ACTION_DOWN) {
            //mLastX = mX;
            mLastY = mY;
        }
        //mOffsetX = (int) ev.getRawX() - mX;
        //mOffsetY = (int) ev.getRawY() - mY;
    }

