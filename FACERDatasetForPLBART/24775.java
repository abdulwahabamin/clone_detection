    public void setRecyclerViewLayoutManager(RecyclerView recyclerView) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition =
                    ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }

        LinearLayoutManagerWithSmoothScroll linearLayoutManagerWithSmoothScroll =new LinearLayoutManagerWithSmoothScroll(this);


        recyclerView.setLayoutManager(linearLayoutManagerWithSmoothScroll);
        recyclerView.scrollToPosition(scrollPosition);

    }

