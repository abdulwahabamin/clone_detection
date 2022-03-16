    @Override
    protected void clearMemory() {
        mPresenter.destroy();
        mHandler.removeMessages(MSG_START);
        mHandler.removeMessages(MSG_NAVIGATE_CITY_WEATHER);
        mHandler.removeMessages(MSG_NAVIGATE_CITIES);
        mHandler.removeCallbacks(delayStartProc);
        uninitView();
        //mUnbinder.unbind();
    }

