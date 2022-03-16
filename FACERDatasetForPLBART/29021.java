    private void requestWeather() {
        weatherApi.getWeather(cityCountryName, API_KEY).enqueue(new Callback<Response>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                Response model = response.body();

                if (model != null) {
                    Log.d(TAG, model.toString());

                    tvCityCountryName.setText(model.getName() + ", " + model.getSys().getCountry());
                    tvConditionDescription.setText(model.getWeather().get(0).getMain() + " (" +(model.getWeather().get(0).getDescription() + ")"));
                    tvTemperature.setText("" + Math.round((model.getMain().getTemp() - 273.15)) + (char) 0x00B0 + "C");
                    tvHumidity.setText(model.getMain().getHumidity() + "%");
                    tvPressure.setText(model.getMain().getPressure() + " hPa");
                    tvWindSpeedDegrees.setText(model.getWind().getSpeed() + " mps, " + model.getWind().getDeg() + (char) 0x00B0);

                    requestWeatherIcon(model);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Check internet connection or try again later", Toast.LENGTH_SHORT)
                        .show();
                Log.d(TAG, "Weather request error: " + t.getMessage());
            }
        });
    }

