    public void setHumidity(int humidity) {
        TextView view = (TextView) getActivity().findViewById(R.id.header_humidity);
        if (view != null) {
            Resources res = getResources();
            String humidityText = res.getString(R.string.format_humidity, humidity);
            view.setText(humidityText);
        }
    }

