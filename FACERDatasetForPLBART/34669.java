    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityManageViewHolder holder = new CityManageViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_city_manage, parent, false);

            holder.cityName = (TextView) convertView.findViewById(R.id.city_name);
            holder.cond = (TextView) convertView.findViewById(R.id.weather_cond);
            holder.tmp = (TextView) convertView.findViewById(R.id.weather);
            holder.time = (TextView) convertView.findViewById(R.id.updateTime);
            holder.hum = (TextView) convertView.findViewById(R.id.wet);
            holder.itemCard = (LinearLayout)convertView.findViewById(R.id.item_card);
            convertView.setTag(holder);
        }else{
            holder = (CityManageViewHolder) convertView.getTag();
        }
        holder.cityName.setText(cities.get(position).getCityName());
        String weatherCode = cities.get(position).getCode();
        int radius = 30;
        float[] outerR = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
        RoundRectShape roundRectShape = new RoundRectShape(outerR, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(ContextCompat.getColor(MyApplication.getAppContext(), WeatherColor.getWeatherColor(weatherCode)));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        holder.itemCard.setBackground(shapeDrawable);
        holder.cond.setText("天气：" + cities.get(position).getCond());
        holder.tmp.setText("气温：" + cities.get(position).getTmp() + "°");
        holder.time.setText(cities.get(position).getTime());
        holder.hum.setText("湿度: " + cities.get(position).getHum() + "%");
        return convertView;
    }

