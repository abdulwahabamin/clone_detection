    /**
     * BitmapFactory.decodeStream method needs background thread
     */
    private void requestWeatherIcon(Response model) {
        weatherApi.getIcon(model.getWeather().get(0).getIcon()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, final @NonNull retrofit2.Response<ResponseBody> response) {
                if (response.body() != null) {

                    new Thread() {
                        @Override
                        public void run() {
                            final Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                            if (bitmap != null) {
                                final Bitmap resizedBitmap = ImageHelper.getResizedBitmap(bitmap, 100, 100);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ivConditionIcon.setImageBitmap(resizedBitmap);
                                    }
                                });
                            }
                        }
                    }.start();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Check internet connection or try again later", Toast.LENGTH_SHORT)
                        .show();
                Log.d(TAG, "Weather icon request error: " + t.getMessage());
            }
        });
    }

