        /**
         * Handles thumb selection and movement. Notifies listener callback on certain events.
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {

                if (!isEnabled())
                        return false;

                int pointerIndex;

                final int action = event.getAction();
                switch (action & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_DOWN:
                        // Remember where the motion event started
                        mActivePointerId = event.getPointerId(event.getPointerCount() - 1);
                        pointerIndex = event.findPointerIndex(mActivePointerId);
                        mDownMotionX = event.getX(pointerIndex);

                        pressedThumb = evalPressedThumb(mDownMotionX);

                        // Only handle thumb presses.
                        if (pressedThumb == null)
                                return super.onTouchEvent(event);

                        setPressed(true);
                        invalidate();
                        onStartTrackingTouch();
                        trackTouchEvent(event);
                        attemptClaimDrag();

                        break;
                case MotionEvent.ACTION_MOVE:
                        if (pressedThumb != null) {

                                if (mIsDragging) {
                                        trackTouchEvent(event);
                                }
                                else {
                                        // Scroll to follow the motion event
                                        pointerIndex = event.findPointerIndex(mActivePointerId);
                                        final float x = event.getX(pointerIndex);

                                        if (Math.abs(x - mDownMotionX) > mScaledTouchSlop) {
                                                setPressed(true);
                                                invalidate();
                                                onStartTrackingTouch();
                                                trackTouchEvent(event);
                                                attemptClaimDrag();
                                        }
                                }

                                listener.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
                                if (notifyWhileDragging && listener != null) {
                                        listener.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
                                }
                        }
                        break;
                case MotionEvent.ACTION_UP:
                        if (mIsDragging) {
                                trackTouchEvent(event);
                                onStopTrackingTouch();
                                setPressed(false);
                        }
                        else {
                                // Touch up when we never crossed the touch slop threshold
                                // should be interpreted as a tap-seek to that location.
                                onStartTrackingTouch();
                                trackTouchEvent(event);
                                onStopTrackingTouch();
                        }

                        pressedThumb = null;
                        invalidate();
                        if (listener != null) {
                                listener.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
                        }
                        break;
                case MotionEvent.ACTION_POINTER_DOWN: {
                        final int index = event.getPointerCount() - 1;
                        // final int index = ev.getActionIndex();
                        mDownMotionX = event.getX(index);
                        mActivePointerId = event.getPointerId(index);
                        invalidate();
                        break;
                }
                case MotionEvent.ACTION_POINTER_UP:
                        onSecondaryPointerUp(event);
                        invalidate();
                        break;
                case MotionEvent.ACTION_CANCEL:
                        if (mIsDragging) {
                                onStopTrackingTouch();
                                setPressed(false);
                        }
                        invalidate(); // see above explanation
                        break;
                }
                return true;
        }

