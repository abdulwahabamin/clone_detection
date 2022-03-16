    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int height = 0;
        int count = getChildCount();
        for(int i = 0;i < count;i++) {
            View child = getChildAt(i);
            MarginLayoutParams params = (MarginLayoutParams)child.getLayoutParams();
            int leftMargin = params.leftMargin;
            int topMargin = params.topMargin;
            int rightMargin = params.rightMargin;
            int bottomMargin = params.bottomMargin;
            height += topMargin;
            child.layout(leftMargin,height,screenWidth - rightMargin,height + child.getMeasuredHeight());
            height += child.getMeasuredHeight() + bottomMargin;
        }
    }

