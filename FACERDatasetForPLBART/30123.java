    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        myViewHolder.tvItemCity.setText(datas.get(i).getCityName());
        myViewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityBeanList favorCity = SpUtils.getBean(activity, "cityBean", CityBeanList.class);
                CityBeanList favorCityEn = SpUtils.getBean(activity, "cityBeanEn", CityBeanList.class);
                List<CityBean> cityBeans = favorCity.getCityBeans();
                List<CityBean> cityBeansEn = favorCityEn.getCityBeans();
                for (int x = 0; x < cityBeans.size(); x++) {
                    if (cityBeans.get(x).getCityId().equals(datas.get(i).getCityId())) {
                        cityBeans.remove(x);
                    }
                }
                for (int x = 0; x < cityBeansEn.size(); x++) {
                    if (cityBeansEn.get(x).getCityId().equals(datas.get(i).getCityId())) {
                        cityBeansEn.remove(x);
                    }
                }

                datas.remove(i);

                CityBeanList cityBeanList = new CityBeanList();
                cityBeanList.setCityBeans(cityBeans);
                CityBeanList cityBeanListEn = new CityBeanList();
                cityBeanListEn.setCityBeans(cityBeansEn);
                SpUtils.saveBean(activity, "cityBeanEn", cityBeanListEn);
                SpUtils.saveBean(activity, "cityBean", cityBeanList);
                //删除动画
                notifyItemRemoved(i);
                notifyDataSetChanged();
                ContentUtil.CITY_CHANGE = true;
//                DataUtil.deleteId(i);
            }
        });
    }

