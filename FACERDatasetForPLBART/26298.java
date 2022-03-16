    public void onMatched(List<CityInfoData> result) {

        if (Check.isEmpty(result)) {
            mEmptyView.setVisibility(View.VISIBLE);
        } else {
            mEmptyView.setVisibility(View.GONE);
            mSearchResultAdapter.setData(result);

        }
    }

