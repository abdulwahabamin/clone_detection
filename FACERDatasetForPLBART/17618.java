    @Override
    public void displayListData(final MediaBrowserCompat.MediaItem item,
                                String artPath,
                                final List<MediaBrowserCompat.MediaItem> itemList) {

        RequestOptions options = new RequestOptions();
        options.centerCrop().placeholder(R.drawable.default_artist_art);

        if (artPath != null) {
            Glide.with(getActivity())
                    .asBitmap()
                    .listener(new RequestListener<Bitmap>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e,
                                                    Object model,
                                                    Target<Bitmap> target,
                                                    boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource,
                                                       Object model,
                                                       Target<Bitmap> target,
                                                       DataSource dataSource,
                                                       boolean isFirstResource) {
                            updateUi(item, resource, itemList);
                            return false;
                        }


                    })
                    .load(artPath)
                    .apply(options)
                    .transition(BitmapTransitionOptions.withCrossFade())
                    .into(artIv);
        } else {
            Glide.with(getActivity()).clear(artIv);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                artIv.setImageDrawable(getActivity().getDrawable(R.drawable.default_artist_art));
            } else {
                artIv.setImageDrawable(
                        getActivity()
                                .getResources()
                                .getDrawable(R.drawable.default_artist_art));
            }
            updateUi(item, null, itemList);
        }
    }

