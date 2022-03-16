            public MyViewHolder(View itemView) {
                super(itemView);
                weatherBG = itemView.findViewById(R.id.weather_bg);
                weatherIcon = (ImageView) itemView.findViewById(R.id.weather_icon);
                weatherCond = (TextView) itemView.findViewById(R.id.weather_cond);
                weathertmp = (TextView) itemView.findViewById(R.id.weather_tmp);
                weaatherCity = (TextView) itemView.findViewById(R.id.weather_city);
                weatherWind = (TextView) itemView.findViewById(R.id.weather_wind);
                weatherHum = (TextView) itemView.findViewById(R.id.weather_hum);
                weatherPres = (TextView) itemView.findViewById(R.id.weather_pres);
            }

