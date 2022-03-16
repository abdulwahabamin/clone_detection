    @Override
    public void showPlayIcon() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            playPauseIb.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_play_arrow_black_48dp, null));
        } else {
            playPauseIb.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_play_arrow_black_48dp));
        }
    }

