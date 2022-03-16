    private WeatherFort gsonFort() throws IOException{
        URL fort = new URL(builtFort.toString());
        HttpURLConnection connection1 = (HttpURLConnection) fort.openConnection();
        connection1.addRequestProperty("x-api-key", preferences.getWeatherKey());

        InputStream content = connection1.getInputStream();

        try {
            //Read the server response and attempt to parse it as JSON
            Reader reader = new InputStreamReader(content);

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("M/d/yy hh:mm a");
            Gson gson = gsonBuilder.create();
            WeatherFort posts = gson.fromJson(reader, WeatherFort.class);
            System.out.println(gson.toJson(posts));
            content.close();
            return posts;
        } catch (Exception ex) {
            Log.e("FetchWeather", "Failed to parse JSON due to: " + ex);
        }
        return null;
    }

