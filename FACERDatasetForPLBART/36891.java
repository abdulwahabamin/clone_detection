    @Override
    public void onRefresh() {
        mQuery.setSkip(0);
        mQuery.findObjects(new FindListener<ImageWeather>() {
            @Override
            public void done(List<ImageWeather> list, BmobException e) {
                if (e == null) {
                    mImageList.clear();
                    mImageList.addAll(list);
                    mAdapter.notifyDataSetChanged();
                    mRefreshLayout.setRefreshing(false);
                    mLoadMoreListener.setEnableLoadMore(true);
                    famAddPhoto.setVisibility(View.VISIBLE);
                } else {
                    Log.e(TAG, "query image fail", e);
                    mRefreshLayout.setRefreshing(false);
                    SnackbarUtils.show(ImageWeatherActivity.this, R.string.refresh_fail);
                }
            }
        });
    }

