    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.welcome_start:
                SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                editor.putBoolean("first_start", false);
                editor.commit();
                finish();
                break;
            default:
                break;
        }
    }

