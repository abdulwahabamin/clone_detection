    @Override
    public void showFavButtonEnabled() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            heartIv
                    .setImageDrawable(
                            getActivity().getDrawable(R.drawable.ic_heart_solid_light_pink_24dp));
        } else {
            heartIv.setImageDrawable(
                    getActivity()
                            .getResources()
                            .getDrawable(R.drawable.ic_heart_solid_light_pink_24dp));
        }
    }

