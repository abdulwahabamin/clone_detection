        @OnClick(R.id.city_weather_item_layout)
        public void onCityWeatherItemClicked() {

            if (clickListener != null && cityWeatherList.size() > getAdapterPosition()) {

                clickListener.onCityWeatherClicked(cityWeatherList.get(getAdapterPosition()));
            }
        }

