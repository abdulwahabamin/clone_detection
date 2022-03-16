    private void askForInfos(final String url) {
        // Get the data of the video form the api
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException ignored) {
                sendToast("Download Failed, Code : 1");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    sendToast("Download Failed, Code : 2");
                    return;
                }
                try {
                    final String jsonData = response.body().string();
                    final JSONObject jsonObject = new JSONObject(jsonData);
                    final String error = jsonObject.optString("error");
                    if (!error.isEmpty()) {
                        sendToast(error + ", Code : 3");
                        return;
                    }
                    final String downloadUrl = jsonObject.getString("downloadUrl");
                    final String fileName = jsonObject.getString("fileName");
                    // Launch the download of the video converted in mp3
                    startDownload(downloadUrl, fileName);
                    sendToast("Download started");
                } catch (JSONException ignored) {
                    sendToast("Download Failed, Code : 0");
                }
            }
        });
    }

