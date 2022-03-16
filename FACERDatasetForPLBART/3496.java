    public void setRotation(float rotation) {
        if (mRotationZ != rotation) {
            prepareForUpdate();
            mRotationZ = rotation;
            invalidateAfterUpdate();
        }
    }

