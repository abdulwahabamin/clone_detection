    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String jsonString = savedInstanceState.getString(WEATHER_INFO_JSON_STRING);
        if (jsonString != null) {
            searchResponseForFindQuery = new Gson().fromJson(jsonString,
                    SearchResponseForFindQuery.class);
        }
    }

