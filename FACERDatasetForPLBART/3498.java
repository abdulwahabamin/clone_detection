    public void setRotationX(float rotationX) {
        if (mRotationX != rotationX) {
            prepareForUpdate();
            mRotationX = rotationX;
            invalidateAfterUpdate();
        }
    }

