    public void setWindSpeed(double windSpeed, String windDir) {
        TextView view = (TextView) getActivity().findViewById(R.id.header_wind);
        if (view != null) {
            Resources res = getResources();
            String windText = res.getString(R.string.format_wind,
                     windSpeed, isMetric?"m/s":"mph", windDir);
            view.setText(windText);
        }
    }

