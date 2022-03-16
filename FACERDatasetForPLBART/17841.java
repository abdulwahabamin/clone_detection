    @Override
    public void setRepeatModeOne() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            repeatIb
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_repeat_one_grey_24dp));
        } else {
            repeatIb.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_repeat_one_grey_24dp));
        }
    }

