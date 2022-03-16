    @Override
    public void onLoadMore() {
        mQuery.setSkip(mImageList.size());
        mQuery.findObjects(new FindListener<ImageWeather>() {
            @Override
            public void done(List<ImageWeather> list, BmobException e) {
                if (e == null) {
                    mLoadMoreListener.onLoadComplete();
                    if (!list.isEmpty()) {
                        mImageList.addAll(list);
                        mAdapter.notifyDataSetChanged();
                    } else {
                        mLoadMoreListener.setEnableLoadMore(false);
                        SnackbarUtils.show(ImageWeatherActivity.this, R.string.no_more);
                    }
                } else {
                    Log.e(TAG, "query image fail", e);
                    mLoadMoreListener.onLoadComplete();
                    SnackbarUtils.show(ImageWeatherActivity.this, R.string.load_fail);
                }
            }
        });
    }

