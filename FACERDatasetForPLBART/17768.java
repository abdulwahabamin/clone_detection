    @Override
    public void setRepeatModeAll() {
        repeatNotifyIv.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            repeatNotifyIv
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_repeat_black_12dp));
        } else {
            repeatNotifyIv.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_repeat_black_12dp));
        }
    }

