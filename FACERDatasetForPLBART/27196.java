    public void setTemp(double temperature) {
        TextView view = (TextView) getActivity().findViewById(R.id.header_temp);
        if (view != null) {
            Resources res = getResources();
            String temperatureText = temperature > 0 ?
                    res.getString(R.string.format_temp_plus, temperature, isMetric ? "°C" : "°F") :
                    res.getString(R.string.format_temp_minus, temperature, isMetric ? "°C" : "°F");
            view.setText(temperatureText);
        }
    }

