    @Override
    public void initView() {
        toolbar.setTitle("选择城市");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true); //设置返回键�?�用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fm = getSupportFragmentManager();
        ProvinceFragment fragment = (ProvinceFragment) fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new ProvinceFragment();
        }
        if (!fragment.isAdded()) {
            fm.beginTransaction().add(R.id.fragment_container,fragment,ProvinceFragment.TAG).commit();
        }
        fm.beginTransaction().show(fragment).commit();

        mPresenter = new ProvincePresenter(fragment);
    }

