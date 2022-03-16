    @Override
    public void onClick(View view) {
        int listItemPosition = getListView().getPositionForView(view);
        int cityId = cursorAdapter.getCityId(listItemPosition);
        String cityName = cursorAdapter.getCityName(listItemPosition);

        int viewId = view.getId();
        switch (viewId) {
            case R.id.city_rename_button:
                onUtilityButtonClickedListener.onCityNameChangeRequested(cityId, cityName);
                break;
            case R.id.city_remove_button:
                onUtilityButtonClickedListener.onCityRecordDeletionRequested(cityId, cityName);
                break;
            default:
                throw new IllegalArgumentException("Not supported view ID: " + viewId);
        }
    }

