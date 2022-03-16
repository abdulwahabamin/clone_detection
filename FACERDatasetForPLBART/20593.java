    public void setRotationY(float rotationY) {
        if (mRotationY != rotationY) {
            prepareForUpdate();
            mRotationY = rotationY;
            invalidateAfterUpdate();
        }
    }

