    /**
     * 更新城市列表:
     * 1/(cityName, null)-删除cityName.
     * 2/(null, "remove")-删除cityName�?�更新列表，并指定第一个城市为nonce_city，然�?�展示当�?城市.
     * 3/(cityName, "add")-添加cityName到城市列表，并指定为nonce_city，然�?�展示当�?城市.
     * 4/(null, null)-更新城市列表，然�?�展示当�?城市.
     *
     * @author �?�?宇 2016-8-7 下�?�2:07:58
     */
    private void updateCityList(String cityName, String weatherCode) {
        if (cityName != null && weatherCode == null) {
            // �?�传入城市�??时：删除该城市并更新
            SharedPreferences.Editor editor = getSharedPreferences("data_city", MODE_PRIVATE).edit();
            editor.remove(cityName);
            editor.commit();
            editor = getSharedPreferences(cityName, MODE_PRIVATE).edit();
            editor.clear();
            editor.commit();
            updateCityList(null, "remove");
        } else {
            // 将新添加的城市更新到HashMap和ArrayList中
            SharedPreferences prefs = getSharedPreferences("data_city", MODE_PRIVATE);
            cityName_weatherCode.clear();
            cityName_weatherCode.putAll((HashMap<String, String>) prefs.getAll());
            cities.clear();
            ArrayList<String> temp = new ArrayList<String>(10);
            temp.addAll(cityName_weatherCode.keySet());

            // �?始化城市列表数�?�
            for (int i = 0; i < temp.size(); i++) {
                CityList t = new CityList(temp.get(i));
                cities.add(t);
            }

            // 如果有传入flag标记，则�?明是刚刚删除了城市，所以�?�?新指定nonce_city
            if (weatherCode != null) {
                if (weatherCode.equals("remove")) {
                    // 更新当�?城市的标记，并显示当�?列表中第一个城市
                    SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                    if (temp.size() != 0) {
                        editor.putString("nonce_city", temp.get(0));
                        editor.commit();
                        showWeather(temp.get(0));
                    } else {
                        editor.putString("nonce_city", null);
                        editor.commit();
                        showWeather(null);
                    }
                } else if (weatherCode.equals("add")) {
                    SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                    editor.putString("nonce_city", cityName);
                    editor.commit();
                    showWeather(cityName);
                }
            } else {
                SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                editor.commit();
                prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
                showWeather(prefs.getString("nonce_city", null));
            }

            CityListAdapter adapter = new CityListAdapter(WeatherActivity.this, R.layout.citylist_item, cities);
            city_list.setAdapter(adapter);

            // 为城市列表建立点击监�?�事件（显示点击的城市）
            city_list.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    drawer_layout.closeDrawers();
                    CityList t = cities.get(position);
                    showWeather(t.getCityName());
                }
            });

            // 为城市列表建立长按监�?�事件（删除长按的城市）
            city_list.setOnItemLongClickListener(new OnItemLongClickListener() {

                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                    // 弹出确认删除对�?框
                    alert = null;
                    builder = new AlertDialog.Builder(WeatherActivity.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                    alert = builder.setMessage("真的�?删除我�?�~").setNegativeButton("�?�消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CityList t = cities.get(position);
                            updateCityList(t.getCityName(), null);
                        }
                    }).create(); // 创建AlertDialog对象
                    alert.show(); // 显示对�?框

                    // 长按事件�?��?想继续执行点击事件时，应返回true
                    return true;
                }
            });
        }
    }

