    @Override
    public void onResume() {
        super.onResume();
        if (scrollView != null) {
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                @Override
                public void onScrollChanged() {
                    if (mSwipeLayout != null) {
                        mSwipeLayout.setEnabled(scrollView.getScrollY() == 0);
                    }
                }
            });
        }
    }

