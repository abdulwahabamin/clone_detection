    public void setX(float x) {
        View view = mView.get();
        if (view != null) {
            setTranslationX(x - view.getLeft());
        }
    }

