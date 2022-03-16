    private URL provideURL(String[] reqParams) throws UnsupportedEncodingException, MalformedURLException {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String apiKey = sp.getString("apiKey", activity.getResources().getString(R.string.apiKey));

        StringBuilder urlBuilder = new StringBuilder("https://api.openweathermap.org/data/2.5/");
        urlBuilder.append(getAPIName()).append("?");
        if (reqParams.length > 0) {
            final String zeroParam = reqParams[0];
            if ("coords".equals(zeroParam)) {
                urlBuilder.append("lat=").append(reqParams[1]).append("&lon=").append(reqParams[2]);
            } else if ("city".equals(zeroParam)) {
                urlBuilder.append("q=").append(reqParams[1]);
            }
        } else {
            final String cityId = sp.getString("cityId", Constants.DEFAULT_CITY_ID);
            urlBuilder.append("id=").append(URLEncoder.encode(cityId, "UTF-8"));
        }
        urlBuilder.append("&lang=").append(Language.getOwmLanguage());
        urlBuilder.append("&mode=json");
        urlBuilder.append("&appid=").append(apiKey);

        return new URL(urlBuilder.toString());
    }

