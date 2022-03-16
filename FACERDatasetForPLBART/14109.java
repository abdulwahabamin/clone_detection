    private HttpURLConnection openPostConnection(String method, Map<String, String> params)
            throws IOException {
        HttpURLConnection urlConnection = openConnection(apiRootUrl);
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);
        urlConnection.setUseCaches(true);
        OutputStream outputStream = urlConnection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String post = buildPostBody(method, params);
        writer.write(post);
        writer.close();
        return urlConnection;
    }

