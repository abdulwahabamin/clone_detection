    @Override
    public void setShuffleModeDisabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            shuffleIb
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_shuffle_light_grey_24dp));
        } else {
            shuffleIb.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_shuffle_light_grey_24dp));
        }
    }

