        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            final WeatherData data = weatherDatas.get(position);
            holder.weaatherCity.setText(data.city);
            holder.weathertmp.setText(data.fl);
            holder.weatherCond.setText(data.cond[1]);
            holder.weatherWind.setText(data.wind);
            holder.weatherHum.setText(data.hum);
            holder.weatherPres.setText(data.pres);
            Uri uri = Uri.parse(WeatherData.getWeatherIconUriByCode(Integer.parseInt(data.cond[0])));
            holder.weatherIcon.setImageDrawable(holder
                    .weatherIcon.getContext()
                    .getDrawable(WeatherData.getWeatherIconDrawableId(Integer.parseInt(data.cond[0]))));

            setWeatherViewColor(holder, data);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context,CityWeatherActivity.class);
                    intent.putExtra("weather",data);
                    context.startActivity(intent);
                }
            });
        }

