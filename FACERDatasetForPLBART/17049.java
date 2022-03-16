    public String request(Request request) throws IOException {
        Response response = okHttpClient.newCall(request).execute();
        String body = response.body().string();

        if (response.isSuccessful()) {
            return body;
        } else {
            throw new RuntimeException(response.message());
        }
    }

