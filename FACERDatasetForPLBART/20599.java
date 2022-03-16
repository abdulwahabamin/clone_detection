    public void setScrollX(int value) {
        View view = mView.get();
        if (view != null) {
            view.scrollTo(value, view.getScrollY());
        }
    }

