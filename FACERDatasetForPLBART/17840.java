    @Override
    public void setRepeatModeAll() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            repeatIb
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_repeat_grey_24dp));
        } else {
            repeatIb.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_repeat_grey_24dp));
        }
    }

