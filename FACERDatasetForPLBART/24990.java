    @Override
    public void changePlayerStyle(int vibrantColor, int backgroundColor, int songPosition) {
        if (songPosition == viewPager.getCurrentItem()) {
            if (vibrantColor == 0) {
                vibrantColor = getResources().getColor(R.color.color_primary);
            }
            if (backgroundColor == 0) {
                backgroundColor = getResources().getColor(R.color.color_primary_dark);
            }
            toolbar.setBackgroundColor(vibrantColor);
            tiltedView.setBackgroundColor(vibrantColor);
            playerBackground.setBackgroundColor(backgroundColor);
        }
        this.songPosition = songPosition;
    }

