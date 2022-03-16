    @Override
    public void onStart() {
        super.onStart();

        // there is a warning because the compiler does not already know if
        // BaseMvpView's child implemented by this class is same as BaseMvpView's
        // child given to Presenter
        mPresenter.onAttach(this);

        mPresenter.onStart();
    }

