    public DragSortListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int defaultDuration = 150;
        int removeAnimDuration = defaultDuration; // ms
        int dropAnimDuration = defaultDuration; // ms

        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs,
                    R.styleable.DragSortListView, 0, 0);

            mItemHeightCollapsed = Math.max(1, a.getDimensionPixelSize(
                    R.styleable.DragSortListView_collapsed_height, 1));

            mTrackDragSort = a.getBoolean(
                    R.styleable.DragSortListView_track_drag_sort, false);

            if (mTrackDragSort) {
                mDragSortTracker = new DragSortTracker();
            }

            // alpha between 0 and 255, 0=transparent, 255=opaque
            mFloatAlpha = a.getFloat(R.styleable.DragSortListView_float_alpha, mFloatAlpha);
            mCurrFloatAlpha = mFloatAlpha;

            mDragEnabled = a.getBoolean(R.styleable.DragSortListView_drag_enabled, mDragEnabled);

            mSlideRegionFrac = Math.max(0.0f,
                    Math.min(1.0f, 1.0f - a.getFloat(
                            R.styleable.DragSortListView_slide_shuffle_speed,
                            0.75f)));

            mAnimate = mSlideRegionFrac > 0.0f;

            float frac = a.getFloat(
                    R.styleable.DragSortListView_drag_scroll_start,
                    mDragUpScrollStartFrac);

            setDragScrollStart(frac);

            mMaxScrollSpeed = a.getFloat(
                    R.styleable.DragSortListView_max_drag_scroll_speed,
                    mMaxScrollSpeed);

            removeAnimDuration = a.getInt(
                    R.styleable.DragSortListView_remove_animation_duration,
                    removeAnimDuration);

            dropAnimDuration = a.getInt(
                    R.styleable.DragSortListView_drop_animation_duration,
                    dropAnimDuration);

            boolean useDefault = a.getBoolean(
                    R.styleable.DragSortListView_use_default_controller,
                    true);

            if (useDefault) {
                boolean removeEnabled = a.getBoolean(
                        R.styleable.DragSortListView_remove_enabled,
                        false);
                int removeMode = a.getInt(
                        R.styleable.DragSortListView_remove_mode,
                        DragSortController.FLING_REMOVE);
                boolean sortEnabled = a.getBoolean(
                        R.styleable.DragSortListView_sort_enabled,
                        true);
                int dragInitMode = a.getInt(
                        R.styleable.DragSortListView_drag_start_mode,
                        DragSortController.ON_DOWN);
                int dragHandleId = a.getResourceId(
                        R.styleable.DragSortListView_drag_handle_id,
                        0);
                int flingHandleId = a.getResourceId(
                        R.styleable.DragSortListView_fling_handle_id,
                        0);
                int clickRemoveId = a.getResourceId(
                        R.styleable.DragSortListView_click_remove_id,
                        0);
                int bgColor = a.getColor(
                        R.styleable.DragSortListView_float_background_color,
                        Color.BLACK);

                DragSortController controller = new DragSortController(
                        this, dragHandleId, dragInitMode, removeMode,
                        clickRemoveId, flingHandleId);
                controller.setRemoveEnabled(removeEnabled);
                controller.setSortEnabled(sortEnabled);
                controller.setBackgroundColor(bgColor);

                mFloatViewManager = controller;
                setOnTouchListener(controller);
            }

            a.recycle();
        }

        mDragScroller = new DragScroller();

        float smoothness = 0.5f;
        if (removeAnimDuration > 0) {
            mRemoveAnimator = new RemoveAnimator(smoothness, removeAnimDuration);
        }
        // mLiftAnimator = new LiftAnimator(smoothness, 100);
        if (dropAnimDuration > 0) {
            mDropAnimator = new DropAnimator(smoothness, dropAnimDuration);
        }

        mCancelEvent = MotionEvent.obtain(0, 0, MotionEvent.ACTION_CANCEL, 0f, 0f, 0f, 0f, 0, 0f,
                0f, 0, 0);

        // construct the dataset observer
        mObserver = new DataSetObserver() {
            private void cancel() {
                if (mDragState == DRAGGING) {
                    cancelDrag();
                }
            }

            @Override
            public void onChanged() {
                cancel();
            }

            @Override
            public void onInvalidated() {
                cancel();
            }
        };
    }

