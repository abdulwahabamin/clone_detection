    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WeatherEntity.Forecast forecast = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (null == convertView) {
            view = LayoutInflater.from(getContext()).inflate(mResourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.tvDate.setText(forecast.getDate());
        viewHolder.tvCentigrade.setText(forecast.getMinTemperature() + "℃ ~ " + forecast.getMaxTemperature() + "℃");
        viewHolder.tvWeatherDesc.setText(forecast.getWeatherDescriptionDaytime());

        return view;
    }

