    /**
     * This method gets the value of the named property from the View object.
     *
     * @param propertyConstant The property whose value should be returned
     * @return float The value of the named property
     */
    private float getValue(int propertyConstant) {
        //final View.TransformationInfo info = mView.mTransformationInfo;
        switch (propertyConstant) {
            case TRANSLATION_X:
                //return info.mTranslationX;
                return mProxy.getTranslationX();
            case TRANSLATION_Y:
                //return info.mTranslationY;
                return mProxy.getTranslationY();
            case ROTATION:
                //return info.mRotation;
                return mProxy.getRotation();
            case ROTATION_X:
                //return info.mRotationX;
                return mProxy.getRotationX();
            case ROTATION_Y:
                //return info.mRotationY;
                return mProxy.getRotationY();
            case SCALE_X:
                //return info.mScaleX;
                return mProxy.getScaleX();
            case SCALE_Y:
                //return info.mScaleY;
                return mProxy.getScaleY();
            case X:
                //return mView.mLeft + info.mTranslationX;
                return mProxy.getX();
            case Y:
                //return mView.mTop + info.mTranslationY;
                return mProxy.getY();
            case ALPHA:
                //return info.mAlpha;
                return mProxy.getAlpha();
        }
        return 0;
    }

