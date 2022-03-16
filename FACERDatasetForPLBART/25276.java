    private void changePlayerStyle(int vibrantColor) {
        track.setTextColor(vibrantColor);
        txtDuration.setTextColor(vibrantColor);
        trackProgress.setCircleProgressColor(vibrantColor);
        trackProgress.setPointerColor(vibrantColor);
        String alphaColor = Integer.toHexString(vibrantColor);
        if (alphaColor.length() > 6) {
            alphaColor = "#88" + alphaColor.substring(2);
        } else {
            alphaColor = "#88" + alphaColor;

        }
        trackProgress.setPointerAlphaOnTouch(Color.parseColor(alphaColor));
        trackProgress.setPointerHaloColor(Color.parseColor(alphaColor));
    }

