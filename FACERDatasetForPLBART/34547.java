        private void setWeatherViewColor(MyViewHolder holder, WeatherData data) {
            holder.weatherBG.setBackgroundColor(holder.weatherBG.getContext().getResources().getColor(WeatherData.getColorByCode(Integer.parseInt(data.cond[0]))));
            int textColor = holder.weatherBG.getContext().getResources().getColor(R.color.white);
            holder.weaatherCity.setTextColor(textColor);
            holder.weathertmp.setTextColor(textColor);
            holder.weatherCond.setTextColor(textColor);

        }

