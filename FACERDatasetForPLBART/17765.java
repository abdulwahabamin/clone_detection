    @Override
    public void setShuffleModeEnabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            shuffleNotifyIv
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_shuffle_black_12dp));
        } else {
            shuffleNotifyIv.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_shuffle_black_12dp));
        }
    }

