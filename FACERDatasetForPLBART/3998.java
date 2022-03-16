    /**
     * This method handles setting the property values directly in the View object's fields.
     * propertyConstant tells it which property should be set, value is the value to set
     * the property to.
     *
     * @param propertyConstant The property to be set
     * @param value The value to set the property to
     */
    private void setValue(int propertyConstant, float value) {
        //final View.TransformationInfo info = mView.mTransformationInfo;
        switch (propertyConstant) {
            case TRANSLATION_X:
                //info.mTranslationX = value;
                mProxy.setTranslationX(value);
                break;
            case TRANSLATION_Y:
                //info.mTranslationY = value;
                mProxy.setTranslationY(value);
                break;
            case ROTATION:
                //info.mRotation = value;
                mProxy.setRotation(value);
                break;
            case ROTATION_X:
                //info.mRotationX = value;
                mProxy.setRotationX(value);
                break;
            case ROTATION_Y:
                //info.mRotationY = value;
                mProxy.setRotationY(value);
                break;
            case SCALE_X:
                //info.mScaleX = value;
                mProxy.setScaleX(value);
                break;
            case SCALE_Y:
                //info.mScaleY = value;
                mProxy.setScaleY(value);
                break;
            case X:
                //info.mTranslationX = value - mView.mLeft;
                mProxy.setX(value);
                break;
            case Y:
                //info.mTranslationY = value - mView.mTop;
                mProxy.setY(value);
                break;
            case ALPHA:
                //info.mAlpha = value;
                mProxy.setAlpha(value);
                break;
        }
    }

