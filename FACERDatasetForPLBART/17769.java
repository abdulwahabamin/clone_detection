    @Override
    public void setRepeatModeOne() {
        repeatNotifyIv.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            repeatNotifyIv
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_repeat_one_black_12dp));
        } else {
            repeatNotifyIv.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_repeat_one_black_12dp));
        }
    }

