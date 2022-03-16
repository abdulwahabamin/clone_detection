    @Override
    public void initData() {
        ButterKnife.bind(this);

        FragmentManager fm = getSupportFragmentManager();
        CityManageFragment fragment = (CityManageFragment) fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = CityManageFragment.newInstance();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
        mPresenter = new CityManagePresenter(fragment);

    }

