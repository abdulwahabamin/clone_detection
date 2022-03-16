    @Override
    protected void clearMemory() {
        stopAnimation();
        mPresenter.destroy();
        mHandler.removeMessages(MSG_WEATHER_UPDATE);
        mHandler.removeCallbacks(rainProc);
        mHandler.removeCallbacks(snowProc);
        mHandler.removeCallbacks(cloudProc);
        mHandler.removeCallbacks(lightningProc);
        mHandler.removeCallbacks(sunshaineProc);
        mHandler.removeCallbacks(quitProc);
        //mUnbinder.unbind();

        uninitView();

        //System.exit(0);
    }

