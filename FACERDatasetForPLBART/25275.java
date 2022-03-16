    private void updatePlayerUI() {
        updateDuration("0:00", milliSecondsToTimer(rhythmSong.getDuration()));
        track.setText(rhythmSong.getTrackTitle());
        if (rhythmSong.getImageData() != null) {
            final Bitmap bmp = BitmapUtils.decodeSampledBitmapFromResource(rhythmSong.getImageData(), 200, 200);
            albumCover.setImageBitmap(bmp);
            Palette.Swatch vibrantSwatch = new Palette.Builder(bmp).generate().getLightVibrantSwatch();
            if (vibrantSwatch != null) {
                vibrantColor = vibrantSwatch.getRgb();
                backgroundColor = vibrantSwatch.getBodyTextColor();
                changePlayerStyle(vibrantSwatch.getRgb());
                callback.changePlayerStyle(vibrantColor, backgroundColor, songPosition);
            } else {
                vibrantColor = getResources().getColor(R.color.color_primary);
                backgroundColor = getResources().getColor(R.color.color_primary_dark);
                callback.changePlayerStyle(vibrantColor, backgroundColor, songPosition);
            }
        }
    }

