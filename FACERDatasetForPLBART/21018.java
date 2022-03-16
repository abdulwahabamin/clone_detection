        public void onClick(View view) {
            TabView tabView = (TabView)view;
            final int oldSelected = mVelocityViewPager.getCurrentItem();
            final int newSelected = tabView.getIndex();
            mVelocityViewPager.setCurrentItem(newSelected);
            if (oldSelected == newSelected && mTabReselectedListener != null) {
                mTabReselectedListener.onTabReselected(newSelected);
            }
        }

