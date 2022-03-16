    private void initTabs() {

        mContainer.removeAllViews();
        mTabs.clear();

        if (mAdapter == null)
            return;

        for (int i = 0; i < mPager.getAdapter().getCount(); i++) {

            final int index = i;

            View tab = mAdapter.getView(i);
            mContainer.addView(tab);

            tab.setFocusable(true);

            mTabs.add(tab);

            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mPager.getCurrentItem() == index) {
                        selectTab(index);
                    } else {
                        mPager.setCurrentItem(index, true);
                    }
                }
            });

        }

        selectTab(mPager.getCurrentItem());
    }

