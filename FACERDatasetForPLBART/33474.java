    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case ACTION_INSERT_OR_UPDATE_CITY_RECORD: {
                int cityId = intent.getIntExtra(MainActivity.CITY_ID, CityTable.
                        CITY_ID_DOES_NOT_EXIST);
                String cityName = intent.getStringExtra(MainActivity.CITY_NAME);
                String currentWeatherJsonString = intent.getStringExtra(RefreshingActivity.
                        WEATHER_INFO_JSON_STRING);
                new SqlOperation(this, WeatherInfoType.CURRENT_WEATHER).
                        updateOrInsertCityWithCurrentWeather(cityId, cityName,
                                currentWeatherJsonString);
                break;
            }
            case ACTION_UPDATE_WEATHER_INFO: {
                int cityId = SharedPrefsHelper.getCityIdFromSharedPrefs(this);
                String jsonString = intent.getStringExtra(RefreshingActivity.
                        WEATHER_INFO_JSON_STRING);
                WeatherInfoType weatherInfoType = intent.getParcelableExtra(RefreshingActivity.
                        WEATHER_INFORMATION_TYPE);
                new SqlOperation(this, weatherInfoType).updateWeatherInfo(cityId,
                        jsonString);
                break;
            }
            case ACTION_RENAME_CITY: {
                int cityId = intent.getIntExtra(CityManagementActivity.CITY_ID,
                        CityTable.CITY_ID_DOES_NOT_EXIST);
                String newName = intent.getStringExtra(CityManagementActivity.CITY_NEW_NAME);
                new SqlOperation(this).renameCity(cityId, newName);
                break;
            }
            case ACTION_DELETE_CITY_RECORDS: {
                int cityId = intent.getIntExtra(CityManagementActivity.CITY_ID, CityTable.
                        CITY_ID_DOES_NOT_EXIST);
                new SqlOperation(this).deleteCity(cityId);
                break;
            }
            case ACTION_DRAG_CITY:
                int cityOrderFrom = intent.getIntExtra(CityManagementActivity.CITY_ORDER_FROM,
                        CityTable.CITY_ID_DOES_NOT_EXIST);
                int cityOrderTo = intent.getIntExtra(CityManagementActivity.CITY_ORDER_TO,
                        CityTable.CITY_ID_DOES_NOT_EXIST);
                new SqlOperation(this).dragCity(cityOrderFrom, cityOrderTo);
                break;
            default:
                throw new IllegalArgumentException("Unsupported action: " + action);
        }
    }

