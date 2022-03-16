    public void setPivotX(float pivotX) {
        if (!mHasPivot || mPivotX != pivotX) {
            prepareForUpdate();
            mHasPivot = true;
            mPivotX = pivotX;
            invalidateAfterUpdate();
        }
    }

