    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        speechPresenter.onDestroy();
        super.onDestroy();
    }

