    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City city = mFilterData.get(position);
        String cityName = city.getCityName();
        String parentName = city.getParent();
        if (!cityName.equals(parentName)) {
            cityName = parentName + "." + cityName;
        }
        holder.cityNameTextView.setText(cityName);
    }

