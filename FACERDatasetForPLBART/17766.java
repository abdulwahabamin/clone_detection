    @Override
    public void setShuffleModeDisabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            shuffleNotifyIv
                    .setImageDrawable(null);
        } else {
            shuffleNotifyIv.setImageDrawable(null);
        }
    }

