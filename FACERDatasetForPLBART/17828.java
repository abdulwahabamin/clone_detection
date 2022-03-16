    private void setUiColorWithSwatch(Palette.Swatch swatch) {

        int backgroundColor = ColorUtil.getBackgroundColor(swatch);
        int titleColor = ColorUtil.getTitleColor(swatch);
        int bodyColor = ColorUtil.getBodyColor(swatch);

        titleTextTv.setBackgroundColor(titleColor);
        bodyTextTv.setBackgroundColor(bodyColor);
        backgroundTextTv.setBackgroundColor(backgroundColor);

        gotoAlbumIv.setColorFilter(titleColor,PorterDuff.Mode.SRC_IN);
        gotoArtistIv.setColorFilter(titleColor,PorterDuff.Mode.SRC_IN);

        topBarTitleTv.setTextColor(titleColor);
        musicPlayerLowerHalfLl.setBackgroundColor(backgroundColor);
        songTitleMainTv.setTextColor(titleColor);
        songArtistMainTv.setTextColor(bodyColor);

        elapsedTimeTv.setTextColor(bodyColor);
        totalTimeTv.setTextColor(bodyColor);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            songCurrentPositionSeekBar.setProgressBackgroundTintList(ColorStateList.valueOf(bodyColor));
            songCurrentPositionSeekBar.setProgressTintList(ColorStateList.valueOf(titleColor));
            songCurrentPositionSeekBar.setThumbTintList(ColorStateList.valueOf(titleColor));
        }
    }

