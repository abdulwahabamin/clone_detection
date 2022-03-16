    public void onAllFollowedCities(List<FollowedCityData> followedCityDatas) {
        mSubscribeCityAdapter.clear();
        mSubscribeCityAdapter.setData(followedCityDatas);
        mSubscribeCityAdapter.addData(mAddData);

        if ((mIsVisibleToUser && !PreferencesHelper.get(CITYS_TIPS_SHOW, false))) {
            mIsVisibleToUser = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.core_AlertDialogStyle);
            builder.setMessage(R.string.city_guide_info);
            builder.setNegativeButton(R.string.core_known, null);
            builder.setPositiveButton(R.string.core_tip_not_show, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    PreferencesHelper.put(CITYS_TIPS_SHOW, true);
                }
            });
            builder.show();
        }

    }

