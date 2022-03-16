    @Override
    public void onClick(View view) {
        int id = view.getId();
        SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
        Intent intent = new Intent(this, WeatherActivity.class);
        switch (id) {
            case R.id.choose_style_1:
                editor.putInt("choose_theme", 1);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_2:
                editor.putInt("choose_theme", 2);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_3:
                editor.putInt("choose_theme", 3);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_4:
                editor.putInt("choose_theme", 4);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_5:
                editor.putInt("choose_theme", 5);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_6:
                editor.putInt("choose_theme", 6);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_7:
                editor.putInt("choose_theme", 7);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_8:
                editor.putInt("choose_theme", 8);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_9:
                editor.putInt("choose_theme", 9);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_10:
                editor.putInt("choose_theme", 10);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_11:
                editor.putInt("choose_theme", 11);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
            case R.id.choose_style_12:
                editor.putInt("choose_theme", 12);
                finish();
                WeatherActivity.instance.finish();
                startActivity(intent);
                break;
        }
        editor.commit();
    }

