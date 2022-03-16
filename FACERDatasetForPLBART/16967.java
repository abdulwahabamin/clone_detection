    public static void loadBlurBg(@NonNull final Context context, @NonNull final ImageView bgView,
                                  @NonNull MediaDescriptionCompat description) {
        Uri iconUri = description.getIconUri();
        if (iconUri == null) {
            ImageHelper.loadBlurBg(context, bgView, getDefaultArt(), DEFAULT_ART_KEY);
            return;
        }
        final String artUrl = iconUri.toString();
        Glide.with(context)
                .load(artUrl)
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(200, 200) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        ImageHelper.loadBlurBg(context, bgView, resource, artUrl);
                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        ImageHelper.loadBlurBg(context, bgView, getDefaultArt(), DEFAULT_ART_KEY);
                    }
                });
    }

