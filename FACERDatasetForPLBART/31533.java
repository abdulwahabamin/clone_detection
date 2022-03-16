    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stop();
        stopAnimation();
    }

