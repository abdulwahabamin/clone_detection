    @Override
    protected void clearMemory() {
        if (mPresenter != null) {
            mPresenter.destroy();
        }

        uninitView();
        //mUnbinder.unbind();
    }

