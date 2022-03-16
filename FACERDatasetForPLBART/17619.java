    public void updateUi(final MediaBrowserCompat.MediaItem item,
                         Bitmap art,
                         final List<MediaBrowserCompat.MediaItem> itemList) {
        if (art != null) {
            ColorUtil.generatePalette(art, new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {

                    itemsRv.setAdapter(
                            new MediaRecyclerViewAdapter(
                                    getVisitableList(
                                            item,
                                            ColorUtil.getColorSwatch(palette),
                                            itemList),
                                    new MediaListTypeFactory()));
                    updateUiColor(ColorUtil.getColorSwatch(palette));
                }
            });
        } else {
            itemsRv.setAdapter(
                    new MediaRecyclerViewAdapter(
                            getVisitableList(
                                    item,
                                    ColorUtil.getColorSwatch(null),
                                    itemList),
                            new MediaListTypeFactory()));
            updateUiColor(ColorUtil.getColorSwatch(null));
        }
    }

