    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(cities.get(holder.getAdapterPosition()));
                }
            }
        });
        String fullName = cities.get(position).getName()+", "+cities.get(position).getAdminName1()+
                ", "+cities.get(position).getCountryName();
        holder.cityName.setText(fullName);
        String flagUrl = "http://www.geonames.org/flags/m/"+
                cities.get(position).getCountryCode().toLowerCase()+".png";
        holder.imageView.setImageURI(Uri.parse(flagUrl));
    }

