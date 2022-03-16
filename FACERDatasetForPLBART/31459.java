    @Override
    protected void clearMemory() {
        mPresenter.destroy();
        mCandidates.clear();

        uninitView();
        //mUnbinder.unbind();
    }

