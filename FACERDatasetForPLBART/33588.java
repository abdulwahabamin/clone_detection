    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = divider;
        if (parent.getChildLayoutPosition(view) == 0)
            outRect.top = divider;
    }

