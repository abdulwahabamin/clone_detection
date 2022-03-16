    @Override
    public void pickWeathers(final List<String> keys, final Action1<List<WeatherData>> action) {
        MyApplication.getInstance().getSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List<WeatherData> list = new ArrayList<>();
                for (String key : keys) {
                    Call<ResponseBody> responseBodyCall = heWeatherREST.getWeatherSync(key, HeWeatherREST.API_KEY);
                    try {
                        String body = responseBodyCall.execute().body().string();
                        WeatherBuilder builder = new HeWeatherBuilder(body);
                        WeatherData data = builder.build();
                        data.cityId = key;
                        list.add(data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                action.call(list);
            }
        });
    }

