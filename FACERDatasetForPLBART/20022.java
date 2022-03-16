    @Override
    protected void layoutChildren() {
        super.layoutChildren();

        if (mFloatView != null) {
            if (mFloatView.isLayoutRequested() && !mFloatViewOnMeasured) {
                // Have to measure here when usual android measure
                // pass is skipped. This happens during a drag-sort
                // when layoutChildren is called directly.
                measureFloatView();
            }
            mFloatView.layout(0, 0, mFloatView.getMeasuredWidth(), mFloatView.getMeasuredHeight());
            mFloatViewOnMeasured = false;
        }
    }

