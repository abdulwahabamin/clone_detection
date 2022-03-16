    public MyFragmentStatePagerAdapter(FragmentManager fm, MainActivity activity){
        super(fm);
        mActivity=activity;
        mSpf=mActivity.getSharedPreferences("WanNianLi",Context.MODE_PRIVATE);
        fragmentQueue=new ArrayDeque<>();
        for(int i=0;i<4;i++){
            MyObjectFragment mof=new MyObjectFragment();
            fragmentQueue.add(mof);
        }

    }

