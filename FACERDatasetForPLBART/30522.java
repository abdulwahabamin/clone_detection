    private Drawable getAirBackground(String aqi) {
        int num = Integer.parseInt(aqi);
        if (getActivity() != null) {
            if (num <= 50) {
                return getActivity().getResources().getDrawable(R.drawable.shape_aqi_excellent);
            } else if (num <= 100) {
                return getActivity().getResources().getDrawable(R.drawable.shape_aqi_good);
            } else if (num <= 150) {
                return getActivity().getResources().getDrawable(R.drawable.shape_aqi_low);
            } else if (num <= 200) {
                return getActivity().getResources().getDrawable(R.drawable.shape_aqi_mid);
            } else if (num <= 300) {
                return getActivity().getResources().getDrawable(R.drawable.shape_aqi_bad);
            } else {
                return getActivity().getResources().getDrawable(R.drawable.shape_aqi_serious);
            }
        } else {
            return MyApplication.getContext().getResources().getDrawable(R.drawable.shape_aqi_excellent);
        }
    }

