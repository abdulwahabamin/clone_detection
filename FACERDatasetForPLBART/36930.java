    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        HourlyForecastAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_holder_hourly_forecast, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTime.setText(timeFormat(mData.get(position).date));
        holder.tvWeather.setText(mData.get(position).cond.txt);
        holder.tvTemp.setText(context.getString(R.string.temp, mData.get(position).tmp));
        holder.tvWind.setText(windFormat(context, mData.get(position).wind.sc));
        return convertView;
    }

