    @Override
    protected void dispatchDraw(Canvas canvas) {
        final ArrayList<View> disappearing = mDisappearingChildren;
        if (mDisappearingFirst && disappearing != null) {
            for (int i = 0; i < disappearing.size(); i++) {
                super.drawChild(canvas, disappearing.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

