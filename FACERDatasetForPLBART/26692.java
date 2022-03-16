    private void setSearchStateVisible(boolean visible) {
        if (mSearchState != null) {
            if (visible) {
                mSearchState.setVisibility(View.VISIBLE);
            } else {
                mSearchState.setVisibility(View.GONE);
            }
        }
    }

