    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item.setTag(mImageList.get(position));
        holder.llPraiseContainer.setTag(mImageList.get(position));
        holder.tvLocation.setText(mImageList.get(position).getLocation().getDistrict().concat(mImageList.get(position).getLocation().getStreet()));
        holder.tvPraiseNum.setText((mImageList.get(position).getPraise() == 0L) ? "" : String.valueOf(mImageList.get(position).getPraise()));
        final String url = mImageList.get(position).getImageUrl();
        Glide.with(mContext)
                .load(url)
                .placeholder(R.drawable.image_weather_placeholder)
                .error(R.drawable.image_weather_placeholder)
                .into(holder.ivImage);
    }

