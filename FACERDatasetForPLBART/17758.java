    @Override
    public void showPauseIcon() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            miniPlayerPlayPauseIv.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_pause_grey_24dp, null));
        } else {
            miniPlayerPlayPauseIv.setImageDrawable(getResources()
                    .getDrawable(R.drawable.ic_pause_grey_24dp));
        }
    }

