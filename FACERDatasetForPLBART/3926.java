    /**
     * This method gets the value of the named property from the View object.
     *
     * @param propertyConstant The property whose value should be returned
     * @return float The value of the named property
     */
    private float getValue(int propertyConstant) {
        //final View.TransformationInfo info = mView.mTransformationInfo;
        View v = mView.get();
        if (v != null) {
            switch (propertyConstant) {
                case TRANSLATION_X:
                    //return info.mTranslationX;
                    return v.getTranslationX();
                case TRANSLATION_Y:
                    //return info.mTranslationY;
                    return v.getTranslationY();
                case ROTATION:
                    //return info.mRotation;
                    return v.getRotation();
                case ROTATION_X:
                    //return info.mRotationX;
                    return v.getRotationX();
                case ROTATION_Y:
                    //return info.mRotationY;
                    return v.getRotationY();
                case SCALE_X:
                    //return info.mScaleX;
                    return v.getScaleX();
                case SCALE_Y:
                    //return info.mScaleY;
                    return v.getScaleY();
                case X:
                    //return v.mLeft + info.mTranslationX;
                    return v.getX();
                case Y:
                    //return v.mTop + info.mTranslationY;
                    return v.getY();
                case ALPHA:
                    //return info.mAlpha;
                    return v.getAlpha();
            }
        }
        return 0;
    }

