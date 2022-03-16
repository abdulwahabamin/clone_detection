    @Override
    public void showPlayIcon() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            miniPlayerPlayPauseIv.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_play_arrow_grey_24dp, null));
        } else {
            miniPlayerPlayPauseIv.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_play_arrow_grey_24dp));
        }
    }

