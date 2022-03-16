    @Override
    public void initView() {

        int position = getIntent().getIntExtra("itemId", 0);
        switch (position){
            case Constants.FUTURE:
                toolbar.setTitle(R.string.future);
                FutureFragment futureFragment = new FutureFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, futureFragment,FutureFragment.TAG).commit();
                mPresenter = new FuturePresenter(futureFragment);
                break;
            case Constants.SETTING:
                toolbar.setTitle(R.string.setting);
                Fragment fragment = new SettingFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, fragment,SettingFragment.TAG).commit();
                break;
            case Constants.SHARE:
                toolbar.setTitle(R.string.share);
                fragment = new ShareFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, fragment,ShareFragment.TAG).commit();
                break;
            case Constants.HELP:
                toolbar.setTitle(R.string.help);
                fragment = new HelpFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, fragment,HelpFragment.TAG).commit();
                break;
            case Constants.LAB:
                toolbar.setTitle(R.string.laboratory);
                fragment = new LaboratoryFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, fragment, LaboratoryFragment.TAG).commit();
                break;
            case Constants.WIKI:
                toolbar.setTitle(R.string.wiki);
                fragment = new WikiFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, fragment, WikiFragment.TAG).commit();
                break;
            case Constants.ABOUT:
                toolbar.setTitle(R.string.about);
                fragment = new AboutFragment();
                fm.beginTransaction()
                        .add(R.id.fragment, fragment,AboutFragment.TAG).commit();
                break;
        }

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true); //设置返回键�?�用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }

