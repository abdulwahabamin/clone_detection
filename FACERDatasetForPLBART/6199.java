    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (mDisappearingFirst && mDisappearingChildren != null
                && mDisappearingChildren.contains(child)) {
            return false;
        }
        return super.drawChild(canvas, child, drawingTime);
    }

