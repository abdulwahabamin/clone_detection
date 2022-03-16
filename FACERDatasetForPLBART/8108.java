    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean update = false;

        switch(event.getAction()) {

        case MotionEvent.ACTION_DOWN:

            mStartTouchPoint = new Point((int)event.getX(), (int)event.getY());

            update = moveTrackersIfNeeded(event);

            break;

        case MotionEvent.ACTION_MOVE:

            update = moveTrackersIfNeeded(event);

            break;

        case MotionEvent.ACTION_UP:

            mStartTouchPoint = null;

            update = moveTrackersIfNeeded(event);

            break;

        }

        if (update) {

            if (mListener != null) {
                mListener.onColorChanged(Color.HSVToColor(mAlpha, new float[]{mHue, mSat, mVal}));
            }

            invalidate();
            return true;
        }


        return super.onTouchEvent(event);
    }

