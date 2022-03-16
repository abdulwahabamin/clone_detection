        @Override
        public ThreeHourlyForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View rowView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_three_hourly_forecast, parent, false);
            return new ThreeHourlyForecastViewHolder(rowView);
        }

