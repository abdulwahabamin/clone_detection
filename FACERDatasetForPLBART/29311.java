    @Override
    public Fragment getItem(int position) {
        MyObjectFragment mof;
        mof=fragmentQueue.poll();
        mof.initFragment(mActivity,position);
        return mof;
    }

