    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // If no flinger support is request, don't change the default behaviour
        if (this.mOnItemFlingerListener == null) {
            return super.onTouchEvent(ev);
        }

        // Get information about the x and y
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        // Detect the motion
        int action = ev.getAction();
        switch (action & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            // Clean variables
            this.mScrolling = false;
            this.mFlinging = false;
            this.mLongPress = false;
            this.mFlingingStarted = false;
            this.mMoveStarted = false;
            this.mFlingingViewPressed = false;
            if (this.mFlingingView != null) {
                this.mFlingingView.setTranslationX(0);
            }

            // Get the view to fling
            this.mFlingingViewPos = pointToPosition(x, y);
            if (this.mFlingingViewPos != INVALID_POSITION) {
                this.mStartX = (int) ev.getX();
                this.mCurrentX = (int) ev.getX();
                this.mStartY = (int) ev.getY();
                this.mCurrentY = (int) ev.getY();
                this.mTranslationX = 0;
                this.mFlingingView =
                        getChildAt(this.mFlingingViewPos - getFirstVisiblePosition());
                this.mFlingingViewPressed = true;

                // Detect long press event
                if (getOnItemLongClickListener() != null) {
                    this.mLongPressDetection = new Runnable() {
                        @Override
                        @SuppressWarnings({"synthetic-access" })
                        public void run() {
                            if (!FlingerListView.this.mFlingingStarted &&
                                !FlingerListView.this.mMoveStarted) {
                                // Notify the long-click
                                FlingerListView.this.mLongPress = true;
                                performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                                FlingerListView.this.mFlingingView.setPressed(false);
                                FlingerListView.this.mFlingingViewPressed = false;
                                getOnItemLongClickListener().onItemLongClick(
                                        FlingerListView.this,
                                        FlingerListView.this.mFlingingView,
                                        FlingerListView.this.mFlingingViewPos,
                                        FlingerListView.this.mFlingingView.getId());
                            }
                        }
                    };
                    this.mFlingingView.postDelayed(
                            this.mLongPressDetection,
                            ViewConfiguration.getLongPressTimeout());
                }

                // Calculate the item size
                Rect r = new Rect();
                this.mFlingingView.getDrawingRect(r);
                this.mFlingingViewWidth = r.width();

                // Set the pressed state
                this.mFlingingView.postDelayed(new Runnable() {
                    @Override
                    @SuppressWarnings("synthetic-access")
                    public void run() {
                        FlingerListView.this.mFlingingView.setPressed(
                                FlingerListView.this.mFlingingViewPressed);
                    }
                }, PRESSED_DELAY_TIME);

                // If not the view is not scrolling the capture event
                if (!mScrollInAnimation) {
                    return true;
                }
            }
            break;

        case MotionEvent.ACTION_MOVE:
            // Detect scrolling
            this.mCurrentY = (int)ev.getY();
            this.mScrolling =
                    Math.abs(this.mCurrentY - this.mStartY) > this.mFlingThresholdY;
            if (this.mFlingingStarted) {
                // Don't allow scrolling
                this.mScrolling = false;
            }

            if ((this.mFlingingStarted || this.mScrolling) && this.mFlingingView != null) {
                this.mFlingingView.removeCallbacks(this.mLongPressDetection);
                this.mFlingingView.setPressed(false);
                this.mFlingingViewPressed = false;
            }

            // With flinging support
            if (this.mFlingingView != null) {
                // Only if event has changed (and only to the right and if not scrolling)
                if (!this.mScrolling) {
                    if ((int)ev.getX() >= this.mStartX && ((int)ev.getX() - this.mCurrentX != 0)) {
                        this.mCurrentX = (int)ev.getX();
                        this.mTranslationX = this.mCurrentX - this.mStartX;
                        this.mFlingingView.setTranslationX(this.mTranslationX);
                        this.mFlingingView.setPressed(false);
                        this.mFlingingViewPressed = false;

                        // Started
                        if (!this.mFlingingStarted) {
                            // Flinging starting
                            if (!mMoveStarted) {
                                if (!this.mOnItemFlingerListener.onItemFlingerStart(
                                        this,
                                        this.mFlingingView,
                                        this.mFlingingViewPos,
                                        this.mFlingingView.getId())) {
                                    this.mCurrentX = 0;
                                    this.mTranslationX = 0;
                                    this.mFlingingView.setTranslationX(this.mTranslationX);
                                    this.mFlingingView.setPressed(false);
                                    this.mFlingingViewPressed = false;
                                    break;
                                }
                            }
                            mMoveStarted = true;
                            if (this.mTranslationX > this.mFlingThresholdX) {
                                this.mFlingingStarted = true;
                            }
                        }

                        // Detect if flinging occurs
                        float flingLimit =
                                (this.mFlingingViewWidth * this.mFlingRemovePercentaje);
                        if (!this.mFlinging && this.mTranslationX > flingLimit) {
                            // Flinging occurs. Mark and raise an event
                            this.mFlinging = true;
                            final ItemFlingerResponder responder =
                                    new ItemFlingerResponder();
                            responder.mItemView = this.mFlingingView;

                            // Request a response (we need to do this in background for
                            // get new events)
                            this.mFlingingView.post(new Runnable() {
                                @Override
                                @SuppressWarnings("synthetic-access")
                                public void run() {
                                    FlingerListView.
                                        this.mOnItemFlingerListener.onItemFlingerEnd(
                                            responder,
                                            FlingerListView.this,
                                            FlingerListView.this.mFlingingView,
                                            FlingerListView.this.mFlingingViewPos,
                                            FlingerListView.this.mFlingingView.getId());
                                }
                            });
                        }
                    }
                } else {
                    this.mCurrentX = 0;
                    this.mTranslationX = 0;
                    this.mFlingingView.setTranslationX(this.mTranslationX);
                    this.mFlingingView.setPressed(false);
                    this.mFlingingViewPressed = false;
                }
            }
            if (this.mFlingingStarted) {
                return true;
            }
            break;

        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            // Clear flinging (only if not waiting confirmation)
            // On scrolling, flinging has no effect
            if (!this.mFlinging || this.mScrolling) {
                this.mStartX = 0;
                this.mCurrentX = 0;
                this.mTranslationX = 0;
                if (this.mFlingingView != null) {
                    this.mFlingingView.setTranslationX(0);
                }
            } else {
                // Force to display at the limit
                if (this.mFlingingView != null) {
                    float flingLimit =
                            (this.mFlingingViewWidth * this.mFlingRemovePercentaje);
                    this.mFlingingView.setTranslationX(flingLimit);
                }
            }

            // What is the motion
            if (!this.mScrolling && this.mFlingingView != null) {
                if (!this.mMoveStarted && !this.mLongPress) {
                    this.mFlingingView.removeCallbacks(this.mLongPressDetection);
                    this.mFlingingView.setPressed(true);
                    this.mFlingingViewPressed = true;
                    performItemClick(
                            this.mFlingingView,
                            this.mFlingingViewPos,
                            this.mFlingingView.getId());

                    // Handled
                    this.mFlingingView.postDelayed(new Runnable() {
                        @Override
                        @SuppressWarnings("synthetic-access")
                        public void run() {
                            FlingerListView.this.mFlingingView.setPressed(false);
                            FlingerListView.this.mFlingingViewPressed = false;
                        }
                    }, PRESSED_DELAY_TIME);
                }
                return true;
            }

            // Scrolling -> Remove any status (don't handle event)
            if (this.mFlingingView != null) {
                this.mFlingingView.setPressed(false);
                this.mFlingingViewPressed = false;
            }
            break;

        default:
            break;
        }

        return super.onTouchEvent(ev);
    }

