    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_ADD_COUNTY: {
                if (resultCode == RESULT_OK) {
                    // Add a county
                    County county = (County) data.getSerializableExtra(AddActivity.KEY_SELECTED_COUNTY);
                    L.d(TAG, "Got add result: " + county.toString());
                    if (!mCountyList.contains(county)) {
                        SharedPrefsHelper helper = new SharedPrefsHelper(this);
                        helper.addCounty(county);
                        mCountyList.add(county);
                        refreshViewPager();
                        mVpMain.setCurrentItem(mPagerAdapter.getCount() - 1);
                    }
                }
                break;
            }
        }
    }

