    public void setScrollY(int value) {
        View view = mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), value);
        }
    }

