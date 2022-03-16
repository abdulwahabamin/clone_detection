    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (searchResponseForFindQuery != null) {
            outState.putString(WEATHER_INFO_JSON_STRING,
                    new Gson().toJson(searchResponseForFindQuery));
        }
    }

