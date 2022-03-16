    private void setCityListVisible(boolean visible) {
        if (mCityListView == null) {
            return;
        }
        if (visible) {
            mCityListView.setVisibility(View.VISIBLE);
        } else {
            mCityListView.setVisibility(View.GONE);
        }
    }

