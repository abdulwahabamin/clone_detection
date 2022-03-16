    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        MyViewHolder viewHolder = (MyViewHolder) myViewHolder;
        View itemView = viewHolder.itemView;
        String name = data.get(i).getCityName();
        int x = name.indexOf("-");
        String parentCity = name.substring(0, x);
        String location = name.substring(x + 1);

        String cityName = location + "，" + parentCity + "，" + data.get(i).getAdminArea() + "，" + data.get(i).getCnty();
        if (TextUtils.isEmpty(data.get(i).getAdminArea())) {
            cityName = location + "，" + parentCity + "，" + data.get(i).getCnty();
        }
        if (!TextUtils.isEmpty(cityName)) {
            viewHolder.tvCity.setText(cityName);
            if (cityName.contains(searchText)) {
                int index = cityName.indexOf(searchText);
                //创建一个 SpannableString对象
                SpannableString sp = new SpannableString(cityName);
                //设置高亮样�?一
                sp.setSpan(new ForegroundColorSpan(activity.getResources().getColor(R.color.light_text_color)), index, index + searchText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                viewHolder.tvCity.setText(sp);
            }
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String cid = data.get(i).getCityId();
                if (lang.equals(Lang.CHINESE_SIMPLIFIED)) {
                    saveData(Lang.ENGLISH, "cityBeanEn", cid);
                    saveBean("cityBean", cid, i);
                } else {
                    saveData(Lang.CHINESE_SIMPLIFIED, "cityBean", cid);
                    saveBean("cityBeanEn", cid, i);
                }
                activity.onBackPressed();
            }
        });
    }

