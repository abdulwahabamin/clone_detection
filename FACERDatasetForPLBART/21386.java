    private void checkForUpdate() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    // Parse JSON
                    String tag_name = (String) response.get("tag_name");
                    String tagVersion = tag_name.substring(1);
                    JSONArray assets = response.getJSONArray("assets");
                    String browser_download_url = assets.getJSONObject(0).getString("browser_download_url");

                    // Get App infos
                    PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                    String version = pInfo.versionName;

                    // Update available
                    if (!tagVersion.equals(version)) {
                        // New Update available
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
                        notificationIntent.setData(Uri.parse(browser_download_url));
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, notificationIntent, 0);

                        Notification notification = new NotificationCompat.Builder(MainActivity.this, "hellomusic_update")
                                .setTicker("Update available for Hello Music !")
                                .setSmallIcon(android.R.drawable.ic_menu_upload)
                                .setContentTitle("Update for Hello Music !")
                                .setContentText("Click here to download.")
                                .setContentIntent(pi)
                                .setAutoCancel(true)
                                .build();

                        NotificationManager notificationManager =  (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
                        notificationManager.notify(0, notification);
                    }
                } catch (JSONException | PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(jsonObjectRequest);
    }

