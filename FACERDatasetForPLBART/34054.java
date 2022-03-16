    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Formatting formatting = new Formatting(getActivity());
        final Bundle bundle = getArguments();
        final Toolbar toolbar = view.findViewById(R.id.dialogToolbar);
        final RecyclerView recyclerView = view.findViewById(R.id.locationsRecyclerView);
        final LinearLayout linearLayout = view.findViewById(R.id.locationsLinearLayout);

        toolbar.setTitle("Locations");

        toolbar.setNavigationIcon(R.drawable.ic_close_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        final int theme = getTheme(sharedPreferences.getString("theme", "fresh"));
        final boolean darkTheme = theme == R.style.AppTheme_NoActionBar_Dark ||
                theme == R.style.AppTheme_NoActionBar_Classic_Dark;
        final boolean blackTheme = theme == R.style.AppTheme_NoActionBar_Black ||
                theme == R.style.AppTheme_NoActionBar_Classic_Black;

        if (darkTheme) {
            linearLayout.setBackgroundColor(Color.parseColor("#2f2f2f"));
        }

        if (blackTheme) {
            linearLayout.setBackgroundColor(Color.BLACK);
        }

        try {
            final JSONArray cityListArray = new JSONArray(bundle.getString("cityList"));
            final ArrayList<Weather> weatherArrayList = new ArrayList<>();
            recyclerAdapter =
                    new LocationsRecyclerAdapter(getActivity().getApplicationContext(), weatherArrayList, darkTheme, blackTheme);

            recyclerAdapter.setClickListener(AmbiguousLocationDialogFragment.this);

            for (int i = 0; i < cityListArray.length(); i++) {
                final JSONObject cityObject = cityListArray.getJSONObject(i);
                final JSONObject weatherObject = cityObject.getJSONArray("weather").getJSONObject(0);
                final JSONObject mainObject = cityObject.getJSONObject("main");
                final JSONObject coordObject = cityObject.getJSONObject("coord");
                final JSONObject sysObject = cityObject.getJSONObject("sys");

                final Calendar calendar = Calendar.getInstance();
                final String dateMsString = cityObject.getString("dt") + "000";
                final String city = cityObject.getString("name");
                final String country = sysObject.getString("country");
                final String cityId = cityObject.getString("id");
                final String description = weatherObject.getString("description");
                final String weatherId = weatherObject.getString("id");
                final float temperature = UnitConvertor.convertTemperature(Float.parseFloat(mainObject.getString("temp")), sharedPreferences);
                final double lat = coordObject.getDouble("lat");
                final double lon = coordObject.getDouble("lon");

                calendar.setTimeInMillis(Long.parseLong(dateMsString));

                Weather weather = new Weather();
                weather.setCity(city);
                weather.setCountry(country);
                weather.setId(cityId);
                weather.setDescription(description.substring(0, 1).toUpperCase() + description.substring(1));
                weather.setLat(lat);
                weather.setLon(lon);
                weather.setIcon(formatting.setWeatherIcon(Integer.parseInt(weatherId), isDayTime(weather, calendar)));

                if (sharedPreferences.getBoolean("displayDecimalZeroes", false)) {
                    weather.setTemperature(new DecimalFormat("0.0").format(temperature) + " " + sharedPreferences.getString("unit", "°C"));
                } else {
                    weather.setTemperature(new DecimalFormat("#.#").format(temperature) + " " + sharedPreferences.getString("unit", "°C"));
                }

                weatherArrayList.add(weather);
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(recyclerAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

