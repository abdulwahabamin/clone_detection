    public float getY() {
        View view = mView.get();
        if (view == null) {
            return 0;
        }
        return view.getTop() + mTranslationY;
    }

