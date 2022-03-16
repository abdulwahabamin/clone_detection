    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.tvCity.setText(data.get(i).getCityName());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = data.get(i).getCityId();
                String cityName = data.get(i).getCityName();

                CityBean cityBean = new CityBean();
                cityBean.setCityName(cityName);
                cityBean.setCityId(city);
                CityBeanList cityBeans;
                List<CityBean> citys = new ArrayList<>();

                cityBeans = SpUtils.getBean(activity, "cityBean", CityBeanList.class);
                if (cityBeans != null && cityBeans.getCityBeans() != null) {
                    citys = cityBeans.getCityBeans();
                }else {
                    cityBeans = new CityBeanList();
                }
                citys.add(0, cityBean);
                cityBeans.setCityBeans(citys);
                SpUtils.saveBean(activity, "cityBean", cityBeans);
                SpUtils.saveBean(activity, "cityBeanEn", cityBeans);

                SpUtils.putString(activity, "lastLocation", city);
                DataUtil.setCid(city);
                locListWindow.dismiss();
            }
        });
    }

