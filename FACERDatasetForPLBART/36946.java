    private void deleteCity() {
        adapter.removeItem(position);
        aCache.put(Extras.CITY_LIST, (ArrayList) adapter.getDataList());
        CityInfo currentCity = (CityInfo) aCache.getAsObject(Extras.CITY);
        Activity activity = (Activity) context;
        if (!adapter.getDataList().contains(currentCity)) {
            currentCity = adapter.getDataList().get(0);
            aCache.put(Extras.CITY, currentCity);
            Intent data = new Intent();
            data.putExtra(Extras.CITY, currentCity);
            activity.setResult(Activity.RESULT_OK, data);
        }
        SnackbarUtils.show(activity, R.string.delete_success);
    }

