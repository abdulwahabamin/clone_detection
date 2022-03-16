    public void setPivotY(float pivotY) {
        if (!mHasPivot || mPivotY != pivotY) {
            prepareForUpdate();
            mHasPivot = true;
            mPivotY = pivotY;
            invalidateAfterUpdate();
        }
    }

