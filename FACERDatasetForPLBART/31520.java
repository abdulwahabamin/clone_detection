    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null)
            mPresenter.start();
    }

