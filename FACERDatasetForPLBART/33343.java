    @Override
    public void onCityRecordDeletionRequested(int cityId, String cityName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DeleteCityDialog dialogFragment = (DeleteCityDialog) fragmentManager
                .findFragmentByTag(CITY_DELETE_DIALOG_FRAGMENT_TAG);
        if (dialogFragment == null) {
            dialogFragment = DeleteCityDialog.newInstance(cityId, cityName);
            dialogFragment.show(fragmentManager, CITY_DELETE_DIALOG_FRAGMENT_TAG);
        }
    }

