    private static URL getUrl(String query) throws MalformedURLException {
        String url = Uri.parse(ENDPOINT).buildUpon()
                        .appendQueryParameter("q", query)
                        .appendQueryParameter("type", "like")
                        .appendQueryParameter("cnt", "15")
                        .appendQueryParameter("APPID", APPID)
                        .build().toString();
        return new URL(url);
    }

