    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityViewHolder viewHolder = new CityViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_city, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.city_name);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (CityViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(cities.get(position).getCityName());
        return convertView;
    }

