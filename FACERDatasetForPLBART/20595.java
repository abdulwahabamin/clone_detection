    public void setScaleX(float scaleX) {
        if (mScaleX != scaleX) {
            prepareForUpdate();
            mScaleX = scaleX;
            invalidateAfterUpdate();
        }
    }

