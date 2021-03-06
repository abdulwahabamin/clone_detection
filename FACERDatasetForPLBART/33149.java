    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Current Weather");

        //Bind the views
        cityName = (EditText) findViewById(R.id.city_name);
        cityId = (EditText) findViewById(R.id.city_id);
        coordinates = (EditText) findViewById(R.id.coordinates);
        zipCode = (EditText) findViewById(R.id.zip_code);

        cityNameResult = (TextView) findViewById(R.id.city_result);
        cityIdResult = (TextView) findViewById(R.id.city_id_result);
        coordinatesResult = (TextView) findViewById(R.id.coordinates_result);
        zipCodeResult = (TextView) findViewById(R.id.zip_code_result);

        cityNameSearch = (Button) findViewById(R.id.city_search);
        cityIdSearch = (Button) findViewById(R.id.city_id_search);
        coordinatesSearch = (Button) findViewById(R.id.coordinates_search);
        zipCodeSearch = (Button) findViewById(R.id.zip_code_search);

        cityNameProgress = (ProgressBar) findViewById(R.id.city_progress);
        cityIdProgress = (ProgressBar) findViewById(R.id.city_id_progress);
        coordinatesProgress = (ProgressBar) findViewById(R.id.coordinates_progress);
        zipCodeProgress = (ProgressBar) findViewById(R.id.zip_code_progress);

        cityNameSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityNameProgress.setVisibility(View.VISIBLE);
                String cityNameQuery = cityName.getText().toString();
                if(cityNameQuery.length() > 0) {
                    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.CITYNAME);
                    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), cityNameQuery);
                }
            }
        });

        cityIdSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityIdProgress.setVisibility(View.VISIBLE);
                String cityIdQuery = cityId.getText().toString();
                if(cityIdQuery.length() > 0) {
                    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.CITYID);
                    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), cityIdQuery);
                }
            }
        });

        coordinatesSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coordinatesProgress.setVisibility(View.VISIBLE);
                String coordinatesQuery = coordinates.getText().toString();
                if(coordinatesQuery.length() > 0) {
                    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.COORDINATES);
                    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), coordinatesQuery);
                }
            }
        });

        zipCodeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zipCodeProgress.setVisibility(View.VISIBLE);
                String zipCodeQuery = zipCode.getText().toString();
                if(zipCodeQuery.length() > 0) {
                    WeatherDownloader downloader = new WeatherDownloader(MainActivity.this, WeatherDownloader.Mode.ZIPCODE);
                    downloader.getCurrentWeatherData(getResources().getString(R.string.weather_api_key), zipCodeQuery);
                }
            }
        });

    }

