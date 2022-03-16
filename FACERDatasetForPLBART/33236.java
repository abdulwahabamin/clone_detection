    private String buildUrl(String apiKey, Mode mode, String query) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority(BASE_URL)
                .appendPath(DATA_PATH)
                .appendPath(VERSION_PATH)
                .appendPath(WEATHER_PATH)
                .appendQueryParameter("appid", apiKey);
        switch (mode) {
            case CITYNAME:
                builder.appendQueryParameter("q", query);
                return builder.build().toString();
            case ZIPCODE:
                builder.appendQueryParameter("zip", query);
                return builder.build().toString();
            case COORDINATES:
                String[] coord = query.split(":");
                builder.appendQueryParameter("lat", coord[0]);
                builder.appendQueryParameter("lon", coord[1]);
                return builder.build().toString();
            case CITYID:
                builder.appendQueryParameter("id", query);
                return builder.build().toString();
            default:
                break;
        }
        return null;
    }

