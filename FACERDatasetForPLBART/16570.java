    private void fetchBitmapAsync(final String bitmapUrl,
                                  final NotificationCompat.Builder builder) {
        Glide.with(FireApplication.getInstance())
                .load(bitmapUrl)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(100, 100) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        builder.setLargeIcon(resource);
//                        addActions(builder);
                        notificationManager.notify(NOTIFICATION_ID, builder.build());
                    }
                });
    }

