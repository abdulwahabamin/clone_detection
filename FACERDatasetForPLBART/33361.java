        @Override
        public void onBindViewHolder(CityNameViewHolder holder, final int position) {
            String cityName = cityNames.get(position);
            holder.cityNameTextView.setText(cityName);

            setBackgroundForListRow(position, holder.cityNameTextView);

            int padding = (int) getResources().getDimension(R.dimen.padding_very_large);
            holder.cityNameTextView.setPadding(padding, padding, padding, padding);

            holder.cityNameTextView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    onCityNamesListItemClickedListener.onFoundCityNamesItemClicked(position);
                }
            });
        }

