    public void setTranslationY(float translationY) {
        if (mTranslationY != translationY) {
            prepareForUpdate();
            mTranslationY = translationY;
            invalidateAfterUpdate();
        }
    }

