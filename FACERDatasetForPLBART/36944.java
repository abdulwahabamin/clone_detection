    @Override
    public void onClick(View v) {
        CityInfo currentCity = (CityInfo) aCache.getAsObject(Extras.CITY);
        if (!currentCity.equals(data)) {
            aCache.put(Extras.CITY, data);
        }
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.putExtra(Extras.CITY, data);
        activity.setResult(Activity.RESULT_OK, intent);
        activity.finish();
    }

