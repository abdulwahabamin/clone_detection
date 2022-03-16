    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView mCityName=(TextView)holder.view.findViewById(R.id.listitem_city_name);
        ImageView mWeatherImage=(ImageView)holder.view.findViewById(R.id.listitem_weather_image);
        TextView mTmpRange=(TextView)holder.view.findViewById(R.id.listitem_tmp_range);
        Button mButton=(Button)holder.view.findViewById(R.id.button_delete_city);
        if(isEditting){
            mButton.setVisibility(View.VISIBLE);
        }else{
            mButton.setVisibility(View.GONE);
        }
        mCityName.setText(mData.get(position).getCityName());
        mWeatherImage.setImageResource(mData.get(position).getWeatherCode());
        mTmpRange.setText(mData.get(position).getTmpRange());
    }

