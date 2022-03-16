    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.city = mCities.get(position);
        holder.contentView.setText(holder.city.getCity().getCity_name());
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            holder.imageView.setTransitionName(holder.contentView.getClass().getName() + position);
        }
        if (holder.city.getWeather() != null) {
            Resources res = holder.view.getResources();
            String temperatureText = holder.city.getWeather().getTemp() > 0 ?
                    res.getString(R.string.temperature_plus, holder.city.getWeather().getTemp(),isMetric ? "°C" : "°F") :
                    res.getString(R.string.temperature_minus, holder.city.getWeather().getTemp(),isMetric ? "°C" : "°F");
            holder.temperatureView.setText(temperatureText);
            if (holder.windView != null) {
                    String windText = res.getString(R.string.format_wind,
                            holder.city.getWeather().getWind_speed(),
                            isMetric?"m/s":"mph",
                            holder.city.getWeather().getWind_dir());
                    holder.windView.setText(windText);

            }
            if (holder.humidity != null) {
                String holderText = res.getString(R.string.format_humidity,
                        holder.city.getWeather().getHumidity());
                holder.humidity.setText(holderText);
            }
            if (holder.city.getWeather().getIcon() != null) {
                String fileName = Utility.getImageWithForecast(holder.city.getWeather().getCondition_code(),
                        holder.city.getWeather().getIs_day());
                holder.imageView.setImageURI(Uri.parse("asset:///"+ fileName));
            }
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemChanged(mCurrentPosition);
                mCurrentPosition = holder.getAdapterPosition();
                if (mListener != null) {
                    mListener.onItemClick(holder.city,holder.imageView);
                }
            }
        });
        holder.view.setSelected(mCurrentPosition == position);
    }

