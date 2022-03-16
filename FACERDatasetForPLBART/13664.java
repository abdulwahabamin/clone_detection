    @OnClick(R.id.fab)
    void onFabClick() {
        BaseFragment fragment = (BaseFragment) getFragmentManager().findFragmentByTag(CURRENT_TAG);
        if (fragment == null) {
            fragment = (BaseFragment) getFragmentManager().findFragmentByTag(TAG_DEFAULT);
        }

        fragment.fabClicked();
    }

