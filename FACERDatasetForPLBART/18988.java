    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                         int totalItemCount) {

        // Forward to the delegate
        if (delegate != null) {
            delegate.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }

    }

