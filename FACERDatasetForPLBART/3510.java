    public void setTranslationX(float translationX) {
        if (mTranslationX != translationX) {
            prepareForUpdate();
            mTranslationX = translationX;
            invalidateAfterUpdate();
        }
    }

