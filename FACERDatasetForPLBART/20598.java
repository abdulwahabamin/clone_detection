    public int getScrollX() {
        View view = mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

