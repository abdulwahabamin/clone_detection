    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (!enableLoadMore || isLoading) {
            return;
        }

        int lastVisibleItem = 0;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();

        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
            lastVisibleItem = linearManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredManager = (StaggeredGridLayoutManager) layoutManager;
            int[] lastPositions = new int[staggeredManager.getSpanCount()];
            staggeredManager.findLastVisibleItemPositions(lastPositions);
            lastVisibleItem = max(lastPositions);
        }

        if (lastVisibleItem + 1 == adapter.getItemCount()) {
            Log.i(TAG, "onLoadMore");
            isLoading = true;
            mListener.onLoadMore();
        }
    }

