        private final void trackTouchEvent(MotionEvent event) {
                final int pointerIndex = event.findPointerIndex(mActivePointerId);
                final float x = event.getX(pointerIndex);

                if (Thumb.MIN.equals(pressedThumb)) {
                        setNormalizedMinValue(screenToNormalized(x));
                }
                else if (Thumb.MAX.equals(pressedThumb)) {
                        setNormalizedMaxValue(screenToNormalized(x));
                }
        }

