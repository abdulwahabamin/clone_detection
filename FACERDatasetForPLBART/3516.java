    public void setY(float y) {
        View view = mView.get();
        if (view != null) {
            setTranslationY(y - view.getTop());
        }
    }

