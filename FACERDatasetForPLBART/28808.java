    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            Log.d("debug", "Top: " + String.valueOf(top));
            int bottom = top + mDivider.getIntrinsicHeight();
            Log.d("debug", "Bottom: " + String.valueOf(top));

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

