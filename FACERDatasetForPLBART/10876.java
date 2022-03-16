    @Override
    public boolean onTrackballEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        boolean update = false;


        if (event.getAction() == MotionEvent.ACTION_MOVE) {

            switch(mLastTouchedPanel) {

            case PANEL_SAT_VAL:

                float sat, val;

                sat = mSat + x/50f;
                val = mVal - y/50f;

                if (sat < 0f) {
                    sat = 0f;
                }
                else if (sat > 1f) {
                    sat = 1f;
                }

                if (val < 0f) {
                    val = 0f;
                }
                else if (val > 1f) {
                    val = 1f;
                }

                mSat = sat;
                mVal = val;

                update = true;

                break;

            case PANEL_HUE:

                float hue = mHue - y * 10f;

                if (hue < 0f) {
                    hue = 0f;
                }
                else if (hue > 360f) {
                    hue = 360f;
                }

                mHue = hue;

                update = true;

                break;

            case PANEL_ALPHA:

                if (!mShowAlphaPanel || mAlphaRect == null) {
                    update = false;
                }
                else{

                    int alpha = (int) (mAlpha - x*10);

                    if (alpha < 0) {
                        alpha = 0;
                    }
                    else if (alpha > 0xff) {
                        alpha = 0xff;
                    }

                    mAlpha = alpha;


                    update = true;
                }

                break;
            }


        }


        if (update) {

            if (mListener != null) {
                mListener.onColorChanged(Color.HSVToColor(mAlpha, new float[]{mHue, mSat, mVal}));
            }

            invalidate();
            return true;
        }


        return super.onTrackballEvent(event);
    }

