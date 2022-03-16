    private void setAlbumart() {
        ImageUtils.loadAlbumArtIntoView(album.id, albumArt, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        loadFailed = true;
                        MaterialDrawableBuilder builder = MaterialDrawableBuilder.with(context)
                                .setIcon(MaterialDrawableBuilder.IconValue.SHUFFLE)
                                .setColor(TimberUtils.getBlackWhiteColor(Config.accentColor(context, Helpers.getATEKey(context))));
                        ATEUtils.setFabBackgroundTint(fab, Config.accentColor(context, Helpers.getATEKey(context)));
                        fab.setImageDrawable(builder.build());
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        try {
                            new Palette.Builder(loadedImage).generate(new Palette.PaletteAsyncListener() {
                                                                          @Override
                                                                          public void onGenerated(Palette palette) {
                                                                              Palette.Swatch swatch = palette.getVibrantSwatch();
                                                                              if (swatch != null) {
                                                                                  primaryColor = swatch.getRgb();
                                                                                  collapsingToolbarLayout.setContentScrimColor(primaryColor);
                                                                                  if (getActivity() != null)
                                                                                      ATEUtils.setStatusBarColor(getActivity(), Helpers.getATEKey(getActivity()), primaryColor);
                                                                              } else {
                                                                                  Palette.Swatch swatchMuted = palette.getMutedSwatch();
                                                                                  if (swatchMuted != null) {
                                                                                      primaryColor = swatchMuted.getRgb();
                                                                                      collapsingToolbarLayout.setContentScrimColor(primaryColor);
                                                                                      if (getActivity() != null)
                                                                                          ATEUtils.setStatusBarColor(getActivity(), Helpers.getATEKey(getActivity()), primaryColor);
                                                                                  }
                                                                              }

                                                                              if (getActivity() != null) {
                                                                                  MaterialDrawableBuilder builder = MaterialDrawableBuilder.with(getActivity())
                                                                                          .setIcon(MaterialDrawableBuilder.IconValue.SHUFFLE)
                                                                                          .setSizeDp(30);
                                                                                  if (primaryColor != -1) {
                                                                                      builder.setColor(TimberUtils.getBlackWhiteColor(primaryColor));
                                                                                      ATEUtils.setFabBackgroundTint(fab, primaryColor);
                                                                                      fab.setImageDrawable(builder.build());
                                                                                  } else {
                                                                                      if (context != null) {
                                                                                          ATEUtils.setFabBackgroundTint(fab, Config.accentColor(context, Helpers.getATEKey(context)));
                                                                                          builder.setColor(TimberUtils.getBlackWhiteColor(Config.accentColor(context, Helpers.getATEKey(context))));
                                                                                          fab.setImageDrawable(builder.build());
                                                                                      }
                                                                                  }
                                                                              }
                                                                          }
                                                                      }

                            );
                        } catch (
                                Exception ignored
                                )

                        {

                        }
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {
                    }

                }

        );
    }

