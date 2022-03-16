    private void updateUiColor(Palette.Swatch swatch) {
        backgroundColor = ColorUtil.getBackgroundColor(swatch);
        titleColor = ColorUtil.getTitleColor(swatch);
        bodyColor = ColorUtil.getBodyColor(swatch);

        toolbarLayout.setContentScrimColor(backgroundColor);
        shuffleFab.setBackgroundTintList(ColorStateList.valueOf(titleColor));
        shuffleFab.setColorFilter(backgroundColor, PorterDuff.Mode.SRC_IN);

        itemsRv.setThumbColor(backgroundColor);
        itemsRv.setTrackColor(ColorUtil.makeColorTransparent(bodyColor));

    }

