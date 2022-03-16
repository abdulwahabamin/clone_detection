    @Override
    public void clear() {
        DataSourceManager.getInstance(mContext).clear();
        mContext = null;
        mCityId = null;
    }

