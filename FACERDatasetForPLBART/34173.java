    public WeatherForecastViewHolder(View itemView, Context context,
                                     FragmentManager fragmentManager) {
        super(itemView);
        mContext = context;
        mFragmentManager = fragmentManager;
        itemView.setOnClickListener(this);

        mDateTime = (TextView) itemView.findViewById(R.id.forecast_date_time);
        mIcon = (TextView) itemView.findViewById(R.id.forecast_icon);
        mTemperatureMin = (TextView) itemView.findViewById(R.id.forecast_temperature_min);
        mTemperatureMax = (TextView) itemView.findViewById(R.id.forecast_temperature_max);
    }

