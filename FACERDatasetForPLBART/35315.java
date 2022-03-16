    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_popup_listview, parent,false);
            holder.tmp = (TextView)convertView.findViewById(R.id.tmp);
            holder.wind_class = (TextView)convertView.findViewById(R.id.wind_class);
            holder.wind_speed = (TextView)convertView.findViewById(R.id.wind_speed);
            holder.wind_deg = (TextView)convertView.findViewById(R.id.wind_deg);
            holder.wind_dir = (TextView)convertView.findViewById(R.id.wind_dir);
            holder.hum = (TextView) convertView.findViewById(R.id.hum);
            holder.pop = (TextView)convertView.findViewById(R.id.pop);
            holder.update = (TextView) convertView.findViewById(R.id.update_time_hours);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tmp.setText(hoursWeathers.get(position).getTmp());
        holder.wind_class.setText("风力等级：" + hoursWeathers.get(position).getWind_class());
        holder.wind_deg.setText("风力角度：" + hoursWeathers.get(position).getWind_deg() + "°");
        holder.wind_dir.setText("风�?�：" + hoursWeathers.get(position).getWind_dir());
        holder.wind_speed.setText("风速：" + hoursWeathers.get(position).getWind_speed() + "km/h");
        holder.pop.setText("�?水概率：" + hoursWeathers.get(position).getPop());
        holder.hum.setText("湿度：" + hoursWeathers.get(position).getHum());
        holder.update.setText("预计今天" + hoursWeathers.get(position).getUpdate().split(" ")[1] + "天气情况");

        return convertView;
    }

