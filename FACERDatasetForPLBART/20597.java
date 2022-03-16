    public void setScaleY(float scaleY) {
        if (mScaleY != scaleY) {
            prepareForUpdate();
            mScaleY = scaleY;
            invalidateAfterUpdate();
        }
    }

