    public void ParseDataSingle(String in){
        try {
            JSONObject reader = new JSONObject(in);

            JSONObject city = reader.getJSONObject("city");
            setCity(city.getString("name"));

            JSONArray list = reader.getJSONArray("list");
            JSONObject JSONList = list.getJSONObject(0);

            JSONArray weather = JSONList.getJSONArray("weather");
            JSONObject JSONWeather = weather.getJSONObject(0);

            setDescription(JSONWeather.getString("description"));
            setWeatherId(JSONWeather.getInt("id"));

            //JSONObject sys = reader.getJSONObject("sys");
            String country = city.getString("country");
            //setSunrise(sys.getInt("sunrise"));
            //setSunset(sys.getInt("sunset"));

            JSONObject temp = JSONList.getJSONObject("temp");
            //Integer temperature_min = main.getInt("temp_min");
            setTemperature_max(temp.getDouble("morn"));
            setHumidity(JSONList.getInt("humidity"));
            setPressure(JSONList.getDouble("pressure"));

            //JSONObject wind = reader.getJSONObject("wind");
            setSpeed(JSONList.getDouble("speed"));
            //temperature_min =  Math.round(temperature_min) - kelvin;
            setTemperature_max(temperature_max);


            JSONObject tomorrowJSONList = list.getJSONObject(1);
            JSONObject tomorrowtemp = tomorrowJSONList.getJSONObject("temp");
            setTomorrowTemp(tomorrowtemp.getDouble("day"));
            JSONArray tomorrowweather = tomorrowJSONList.getJSONArray("weather");
            JSONObject tomorrowJSONWeather = tomorrowweather.getJSONObject(0);
            setTomorrowWeatherId(tomorrowJSONWeather.getInt("id"));
            setTomorrowDesc(tomorrowJSONWeather.getString("description"));

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("JSON Parsing", e.toString());
        }
    }

