    public WeatherForecastViewHolder(View itemView,
                                     Context context,
                                     Set<Integer> visibleColumns) {
        super(itemView);
        mContext = context;
        this.visibleColumns = visibleColumns;

        mDate = (TextView) itemView.findViewById(R.id.forecast_date);
        headerTime = (TextView) itemView.findViewById(R.id.forecast_header_time);
        headerIcon = (TextView) itemView.findViewById(R.id.forecast_header_icon);
        headerDescription = (TextView) itemView.findViewById(R.id.forecast_header_description);
        headerTemperature = (TextView) itemView.findViewById(R.id.forecast_header_temperature);
        headerApparentTemperature = (TextView) itemView.findViewById(R.id.forecast_header_apparent_temperature);
        headerWind = (TextView) itemView.findViewById(R.id.forecast_header_wind);
        headerWindDirection = (TextView) itemView.findViewById(R.id.forecast_header_wind_direction);
        headerRainSnow = (TextView) itemView.findViewById(R.id.forecast_header_rainsnow);
        headerHumidity = (TextView) itemView.findViewById(R.id.forecast_header_humidity);
        headerPressure = (TextView) itemView.findViewById(R.id.forecast_header_presure);

        headerTimeUnit = (TextView) itemView.findViewById(R.id.forecast_header_time_unit);
        headerIconUnit = (TextView) itemView.findViewById(R.id.forecast_header_icon_unit);
        headerDescriptionUnit = (TextView) itemView.findViewById(R.id.forecast_header_description_unit);
        headerTemperatureUnit = (TextView) itemView.findViewById(R.id.forecast_header_temperature_unit);
        headerApparentTemperatureUnit = (TextView) itemView.findViewById(R.id.forecast_header_apparent_temperature_unit);
        headerWindUnit = (TextView) itemView.findViewById(R.id.forecast_header_wind_unit);
        headerWindDirectionUnit = (TextView) itemView.findViewById(R.id.forecast_header_wind_direction_unit);
        headerRainSnowUnit = (TextView) itemView.findViewById(R.id.forecast_header_rainsnow_unit);
        headerHumidityUnit = (TextView) itemView.findViewById(R.id.forecast_header_humidity_unit);
        headerPressureUnit = (TextView) itemView.findViewById(R.id.forecast_header_presure_unit);

        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.forecast_recycler_view_item);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

