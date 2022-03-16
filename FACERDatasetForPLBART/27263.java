    private void loadWeatherIcon(final AppWidgetManager appWidgetManager, final int appWidgetId,
                                 final RemoteViews views, String imageUri) {
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.parse(imageUri))
                .setRotationOptions(RotationOptions.autoRotate())
                .setRequestPriority(Priority.HIGH)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        final DataSource<CloseableReference<CloseableImage>>
                dataSource = imagePipeline.fetchDecodedImage(imageRequest, this);
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
            @Override
            public void onNewResultImpl(@Nullable Bitmap bitmap) {
                if (dataSource.isFinished() && bitmap != null){
                    Bitmap bmp = Bitmap.createBitmap(bitmap);
                    views.setImageViewBitmap(R.id.widget_icon, bmp);
                    appWidgetManager.updateAppWidget(appWidgetId, views);
                    dataSource.close();
                }
            }
            @Override
            public void onFailureImpl(DataSource dataSource) {
                Log.e(LOG_TAG, "Failure load bitmap");
                if (dataSource != null) {
                    dataSource.close();
                }
            }
        }, CallerThreadExecutor.getInstance());
    }

