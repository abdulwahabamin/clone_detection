    protected boolean onDragTouchEvent(MotionEvent ev) {
        // we are in a drag
        int action = ev.getAction() & MotionEvent.ACTION_MASK;

        switch (ev.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_CANCEL:
                if (mDragState == DRAGGING) {
                    cancelDrag();
                }
                doActionUpOrCancel();
                break;
            case MotionEvent.ACTION_UP:
                // Log.d("mobeta", "calling stopDrag from onDragTouchEvent");
                if (mDragState == DRAGGING) {
                    stopDrag(false);
                }
                doActionUpOrCancel();
                break;
            case MotionEvent.ACTION_MOVE:
                continueDrag((int) ev.getX(), (int) ev.getY());
                break;
        }

        return true;
    }

