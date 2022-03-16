    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Resources res = holder.view.getResources();
        holder.time.setText(mFormatTime.format(mHours.get(position).getDt()));
        String temperatureText = mHours.get(position).getTemp() > 0 ?
                res.getString(R.string.format_temp_plus, mHours.get(position).getTemp(),
                        isMetric ? "°C" : "°F") :
                res.getString(R.string.format_temp_minus, mHours.get(position).getTemp(),
                        isMetric ? "°C" : "°F");
        holder.temperature.setText(temperatureText);
        String windText = res.getString(R.string.format_wind_hourly,
                mHours.get(position).getWind_speed(),
                isMetric?"m/s":"mph",
                mHours.get(position).getWind_dir());
        holder.wind.setText(windText);
        String humidityText = res.getString(R.string.format_humidity_hourly, mHours.get(position).getHumidity());
        holder.humidity.setText(humidityText);
        String pressureText = res.getString(R.string.format_pressure_hourly,
                mHours.get(position).getPressure(),
                isMetric ? "mmHg." : "psi");
        holder.pressure.setText(pressureText);
        ImageHelper.load("http:" + mHours.get(position).getIcon(), holder.weatherState);
        holder.weatherState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onIconClick(mHours.get(holder.getAdapterPosition()),v);
                }
            }
        });
    }

