    /**
     * to do some key initializement actions,such as
     * offset the pull-header to be hidden, set listener for
     * scrollview
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed&&!loadOnce){
            hideHeaderHeight=-header.getHeight();
            headerLayoutParams=(MarginLayoutParams) header.getLayoutParams();
            headerLayoutParams.topMargin=hideHeaderHeight;
            header.setLayoutParams(headerLayoutParams);
            mScrollView=(ScrollView)getChildAt(1);
            mScrollView.setOnTouchListener(this);
            loadOnce=true;
        }
    }

