    /**
     * 为按键注册监�?�事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share_weather:
                String fileName = "简约天气-分享.jpeg";
                SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
                String cityName = prefs.getString("nonce_city", null);
                prefs = getSharedPreferences("data_city", MODE_PRIVATE);
                final String weatherCode = prefs.getString(cityName, null);
                if (TextUtils.isEmpty(weatherCode)) {
                    ToastUtil.showToast(WeatherActivity.this, "☜ 亲�?先添加一个城市�?�", Toast.LENGTH_SHORT);
                } else if (ScreenShotUtils.shotBitmap(WeatherActivity.this, getExternalCacheDir() + File.separator + fileName)) {
                    ToastUtil.showToast(this, "分享天气给朋�?�", Toast.LENGTH_SHORT);
                    Intent intent = new Intent(WeatherActivity.this, WeatherActivity.class);
                    startActivity(intent);
                    finish();
                    ShareUtils.share(getExternalCacheDir() + File.separator + fileName, "�?�自简约天气的分享", WeatherActivity.this);
                } else {
                    ToastUtil.showToast(WeatherActivity.this, "        一键截图分享失败�?\n\n请�?试打开存储空间�?��?哦", Toast.LENGTH_SHORT);
                }
                break;
            case R.id.menu_left:
                drawer_layout.openDrawer(menu_list);
                break;
            case R.id.add_city:
                Intent intent_add_city = new Intent(this, ChooseAreaActivity.class);
                intent_add_city.putExtra("from_weather_activity", true);
                startActivity(intent_add_city);
                finish();
                break;
            case R.id.choose_theme:
                Intent intent_choose_theme = new Intent(this, ChooseThemeActivity.class);
                drawer_layout.closeDrawers();
                startActivity(intent_choose_theme);
                break;
            case R.id.setting:
                Intent intent_setting = new Intent(this, SettingActivity.class);
                drawer_layout.closeDrawers();
                startActivity(intent_setting);
                break;
            case R.id.about:
                Intent intent_about = new Intent(this, AboutActivity.class);
                drawer_layout.closeDrawers();
                startActivity(intent_about);
                break;
            default:
                break;
        }
    }

