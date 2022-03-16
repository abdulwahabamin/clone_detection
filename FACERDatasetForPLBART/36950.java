    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int halfSpacing = spacing / 2;
        parent.setPadding(halfSpacing, halfSpacing, halfSpacing, halfSpacing);

        outRect.left = halfSpacing;
        outRect.top = halfSpacing;
        outRect.right = halfSpacing;
        outRect.bottom = halfSpacing;
    }

