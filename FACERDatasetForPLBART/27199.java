    public void setPressure(double pressure) {
        TextView view = (TextView) getActivity().findViewById(R.id.header_pressure);
        if (view != null) {
            Resources res = getResources();
            String pressureText = res.getString(R.string.format_pressure, pressure, isMetric ? "mmHg." : "psi");
            view.setText(pressureText);
        }
    }

