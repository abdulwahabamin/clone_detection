        public LifeIndexViewHolder(View itemView, CityWeatherPresenter presenter) {
            super(itemView);
            //ButterKnife.bind(this, itemView);

            tvTitleName = (TextView)itemView.findViewById(R.id.tv_cv_title_name);

            rlLifeIndex1 = (RelativeLayout)itemView.findViewById(R.id.rl_city_weather_life_index_1);
            ivIcon1 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_icon1);
            tvName1 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_name1);
            tvBrief1 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_brief1);
            ivArrow1 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_arrow1);
            tvDesc1 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_desc1);

            rlLifeIndex2 = (RelativeLayout)itemView.findViewById(R.id.rl_city_weather_life_index_2);
            ivIcon2 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_icon2);
            tvName2 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_name2);
            tvBrief2 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_brief2);
            ivArrow2 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_arrow2);
            tvDesc2 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_desc2);

            rlLifeIndex3 = (RelativeLayout)itemView.findViewById(R.id.rl_city_weather_life_index_3);
            ivIcon3 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_icon3);
            tvName3 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_name3);
            tvBrief3 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_brief3);
            ivArrow3 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_arrow3);
            tvDesc3 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_desc3);

            rlLifeIndex4 = (RelativeLayout)itemView.findViewById(R.id.rl_city_weather_life_index_4);
            ivIcon4 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_icon4);
            tvName4 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_name4);
            tvBrief4 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_brief4);
            ivArrow4 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_arrow4);
            tvDesc4 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_desc4);

            rlLifeIndex5 = (RelativeLayout)itemView.findViewById(R.id.rl_city_weather_life_index_5);
            ivIcon5 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_icon5);
            tvName5 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_name5);
            tvBrief5 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_brief5);
            ivArrow5 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_arrow5);
            tvDesc5 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_desc5);

            rlLifeIndex6 = (RelativeLayout)itemView.findViewById(R.id.rl_city_weather_life_index_6);
            ivIcon6 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_icon6);
            tvName6 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_name6);
            tvBrief6 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_brief6);
            ivArrow6 = (ImageView)itemView.findViewById(R.id.iv_city_weather_life_index_arrow6);
            tvDesc6 = (TextView)itemView.findViewById(R.id.tv_city_weather_life_index_desc6);

            rlLifeIndex1.setOnClickListener(this);
            rlLifeIndex1.setTag(presenter);
            rlLifeIndex2.setOnClickListener(this);
            rlLifeIndex2.setTag(presenter);
            rlLifeIndex3.setOnClickListener(this);
            rlLifeIndex3.setTag(presenter);
            rlLifeIndex4.setOnClickListener(this);
            rlLifeIndex4.setTag(presenter);
            rlLifeIndex5.setOnClickListener(this);
            rlLifeIndex5.setTag(presenter);
            rlLifeIndex6.setOnClickListener(this);
            rlLifeIndex6.setTag(presenter);
        }

