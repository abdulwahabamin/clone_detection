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
        View v = mView.get();
        if (v != null) {
            switch (propertyConstant) {
                case TRANSLATION_X:
                    //info.mTranslationX = value;
                    v.setTranslationX(value);
                    break;
                case TRANSLATION_Y:
                    //info.mTranslationY = value;
                    v.setTranslationY(value);
                    break;
                case ROTATION:
                    //info.mRotation = value;
                    v.setRotation(value);
                    break;
                case ROTATION_X:
                    //info.mRotationX = value;
                    v.setRotationX(value);
                    break;
                case ROTATION_Y:
                    //info.mRotationY = value;
                    v.setRotationY(value);
                    break;
                case SCALE_X:
                    //info.mScaleX = value;
                    v.setScaleX(value);
                    break;
                case SCALE_Y:
                    //info.mScaleY = value;
                    v.setScaleY(value);
                    break;
                case X:
                    //info.mTranslationX = value - v.mLeft;
                    v.setX(value);
                    break;
                case Y:
                    //info.mTranslationY = value - v.mTop;
                    v.setY(value);
                    break;
                case ALPHA:
                    //info.mAlpha = value;
                    v.setAlpha(value);
                    break;
            }
        }
    }

