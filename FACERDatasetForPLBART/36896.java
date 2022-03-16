    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case RequestCode.REQUEST_CAMERA:
                compressImage(FileUtils.getCameraImagePath(this));
                break;
            case RequestCode.REQUEST_ALBUM:
                Uri uri = data.getData();
                compressImage(FileUtils.uriToPath(this, uri));
                break;
            case RequestCode.REQUEST_UPLOAD:
                rvImage.scrollToPosition(0);
                mAppBar.setExpanded(true, false);
                mRefreshLayout.setRefreshing(true);
                onRefresh();
                break;
            case RequestCode.REQUEST_VIEW_IMAGE:
                ImageWeather imageWeather = (ImageWeather) data.getSerializableExtra(Extras.IMAGE_WEATHER);
                for (ImageWeather weather : mImageList) {
                    if (weather.getObjectId().equals(imageWeather.getObjectId())) {
                        weather.setPraise(imageWeather.getPraise());
                        break;
                    }
                }
                mAdapter.notifyDataSetChanged();
                break;
        }
    }

