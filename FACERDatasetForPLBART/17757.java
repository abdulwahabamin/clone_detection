    @Override
    public void displaySong(String title, String albumArtPath) {
        miniPlayerSongTitleTv.setText(title);

        RequestOptions options = new RequestOptions();
        options.centerCrop();

        if (albumArtPath != null) {
            Glide.with(getActivity())
                    .asBitmap()
                    .load(albumArtPath)
                    .apply(options)
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
                            ColorUtil.generatePalette(resource, new Palette.PaletteAsyncListener() {
                                @Override
                                public void onGenerated(Palette palette) {
                                    miniPlayerMpb.setProgressTintList(
                                            ColorStateList.valueOf(
                                                    ColorUtil.getBackgroundColor(
                                                            ColorUtil.getColorSwatch(palette))));
                                }
                            });
                            return false;
                        }
                    })
                    .into(miniPlayerNavUpIv);
        } else {
            Glide.with(getActivity()).clear(miniPlayerNavUpIv);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                miniPlayerNavUpIv.setImageDrawable(
                        getActivity().getDrawable(R.drawable.default_song_art));
            } else {
                miniPlayerNavUpIv.setImageDrawable(
                        getActivity()
                                .getResources()
                                .getDrawable(R.drawable.default_song_art));
            }
        }
    }

