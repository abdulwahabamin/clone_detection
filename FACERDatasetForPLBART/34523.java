    private void init() throws JSONException {
        JSONObject jsonObjectWeather = jsonObject.getJSONArray(HE_WEATHER_JSON_KEY)
                .getJSONObject(0);

        //init Basic
        basic = new Basic();
        JSONObject jsonObjectBasic = jsonObjectWeather.getJSONObject(HE_WEATHER_JSON_BASIC);

        basic.city = jsonObjectBasic.getString("city");
        basic.cnty = jsonObjectBasic.getString("cnty");
        basic.id = jsonObjectBasic.getString("id");
        basic.lat = jsonObjectBasic.getString("lat");
        basic.lon = jsonObjectBasic.getString("lon");
        basic.update[0] = jsonObjectBasic.getJSONObject("update").getString("loc");
        basic.update[1] = jsonObjectBasic.getJSONObject("update").getString("utc");


        //init Now
        JSONObject jsonObjectNow = jsonObjectWeather.getJSONObject(HE_WEATHER_JSON_NOW);
        now = new Now();
        now.cond[0] = jsonObjectNow.getJSONObject("cond").getString("code");
        now.cond[1] = jsonObjectNow.getJSONObject("cond").getString("txt");
        now.fl = jsonObjectNow.getString("fl");
        now.hum = jsonObjectNow.getString("hum");
        now.pcpn = jsonObjectNow.getString("pcpn");
        now.pres = jsonObjectNow.getString("pres");
        now.tmp = jsonObjectNow.getString("tmp");
        now.vis = jsonObjectNow.getString("vis");
        now.wind[0] = jsonObjectNow.getJSONObject("wind").getString("deg");
        now.wind[1] = jsonObjectNow.getJSONObject("wind").getString("dir");
        now.wind[2] = jsonObjectNow.getJSONObject("wind").getString("sc");
        now.wind[3] = jsonObjectNow.getJSONObject("wind").getString("spd");

        //init Aqi
        try {
            JSONObject jsonObjectAqi = jsonObjectWeather.getJSONObject(HE_WEATHER_JSON_AQI).getJSONObject("city");
            aqi = new Aqi();
            aqi.aqi = jsonObjectAqi.getString("aqi");
            aqi.co = jsonObjectAqi.getString("co");
            aqi.no2 = jsonObjectAqi.getString("no2");
            aqi.o3 = jsonObjectAqi.getString("o3");
            aqi.pm10 = jsonObjectAqi.getString("pm10");
            aqi.pm25 = jsonObjectAqi.getString("pm25");
            aqi.qlty = jsonObjectAqi.getString("qlty");
            aqi.so2 = jsonObjectAqi.getString("so2");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //init daily forecast
        JSONArray jsonArrayDailyForecasts = jsonObjectWeather.getJSONArray(HE_WEATHER_JSON_DAILY_FORECAST);
        int len = jsonArrayDailyForecasts.length();
        if (len > 0) {
            dailyForecasts = new DailyForecast[len];
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = jsonArrayDailyForecasts.getJSONObject(i);
                DailyForecast df = new DailyForecast();
                df.date = jsonObject.getString("date");
                df.astro[0] = jsonObject.getJSONObject("astro").getString("sr");
                df.astro[1] = jsonObject.getJSONObject("astro").getString("ss");
                df.cond[0] = jsonObject.getJSONObject("cond").getString("code_d");
                df.cond[1] = jsonObject.getJSONObject("cond").getString("code_n");
                df.cond[2] = jsonObject.getJSONObject("cond").getString("txt_d");
                df.cond[3] = jsonObject.getJSONObject("cond").getString("txt_n");
                df.hum = jsonObject.getString("hum");
                df.pcpn = jsonObject.getString("pcpn");
                df.pop = jsonObject.getString("pop");
                df.pres = jsonObject.getString("pres");
                df.tmp[0] = jsonObject.getJSONObject("tmp").getString("max");
                df.tmp[1] = jsonObject.getJSONObject("tmp").getString("min");
                df.vis = jsonObject.getString("vis");
                df.wind[0] = jsonObject.getJSONObject("wind").getString("deg");
                df.wind[1] = jsonObject.getJSONObject("wind").getString("dir");
                df.wind[2] = jsonObject.getJSONObject("wind").getString("sc");
                df.wind[3] = jsonObject.getJSONObject("wind").getString("spd");
                dailyForecasts[i] = df;
            }
        }

        //init hourly forecast
        JSONArray jsonArrayHourlyForecasts = jsonObjectWeather.getJSONArray(HE_WEATHER_JSON_HOURLY_FORECAST);
        int len1 = jsonArrayHourlyForecasts.length();
        if (len1 > 0) {
            hourlyForecasts = new HourlyForecast[len1];
            for (int i = 0; i < len1; i++) {
                JSONObject jsonObjectHourly = jsonArrayHourlyForecasts.getJSONObject(i);
                HourlyForecast hourlyForecast = new HourlyForecast();
                hourlyForecast.date = jsonObjectHourly.getString("date");
                hourlyForecast.hum = jsonObjectHourly.getString("hum");
                hourlyForecast.pop = jsonObjectHourly.getString("pop");
                hourlyForecast.pres = jsonObjectHourly.getString("pres");
                hourlyForecast.tmp = jsonObjectHourly.getString("tmp");
                hourlyForecast.wind[0] = jsonObjectHourly.getJSONObject("wind").getString("deg");
                hourlyForecast.wind[1] = jsonObjectHourly.getJSONObject("wind").getString("dir");
                hourlyForecast.wind[2] = jsonObjectHourly.getJSONObject("wind").getString("sc");
                hourlyForecast.wind[3] = jsonObjectHourly.getJSONObject("wind").getString("spd");
                hourlyForecasts[i] = hourlyForecast;
            }
        }

        //init Suggestion
        JSONObject jsonObjectSuggestion = jsonObjectWeather.getJSONObject(HE_WEATHER_JSON_SUGGESTION);
        suggestion = new Suggestion();
        suggestion.comf[0] = jsonObjectSuggestion.getJSONObject("comf").getString("brf");
        suggestion.comf[1] = jsonObjectSuggestion.getJSONObject("comf").getString("txt");

        suggestion.cw[0] = jsonObjectSuggestion.getJSONObject("cw").getString("brf");
        suggestion.cw[1] = jsonObjectSuggestion.getJSONObject("cw").getString("txt");

        suggestion.drsg[0] = jsonObjectSuggestion.getJSONObject("drsg").getString("brf");
        suggestion.drsg[1] = jsonObjectSuggestion.getJSONObject("drsg").getString("txt");

        suggestion.flu[0] = jsonObjectSuggestion.getJSONObject("flu").getString("brf");
        suggestion.flu[1] = jsonObjectSuggestion.getJSONObject("flu").getString("txt");

        suggestion.sport[0] = jsonObjectSuggestion.getJSONObject("sport").getString("brf");
        suggestion.sport[1] = jsonObjectSuggestion.getJSONObject("sport").getString("txt");

        suggestion.trav[0] = jsonObjectSuggestion.getJSONObject("trav").getString("brf");
        suggestion.trav[1] = jsonObjectSuggestion.getJSONObject("trav").getString("txt");

        suggestion.uv[0] = jsonObjectSuggestion.getJSONObject("uv").getString("brf");
        suggestion.uv[1] = jsonObjectSuggestion.getJSONObject("uv").getString("txt");

    }

