    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityList citylist = getItem(position); // 获�?�当�?项的CityList实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView city_name = (TextView) view.findViewById(R.id.city_name);
        // Button delete_city = (Button) view.findViewById(R.id.delete_city);
        city_name.setText(citylist.getCityName());
        return view;
    }

