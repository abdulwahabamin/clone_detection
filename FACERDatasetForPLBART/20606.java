    public float getX() {
        View view = mView.get();
        if (view == null) {
            return 0;
        }
        return view.getLeft() + mTranslationX;
    }

