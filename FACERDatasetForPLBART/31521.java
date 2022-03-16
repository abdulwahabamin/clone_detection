    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null)
            mPresenter.stop();
    }

