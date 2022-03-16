    /**
     * 为开关按钮注册监�?�事件
     *
     * @param compoundButton
     * @param b
     */
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
        switch (compoundButton.getId()) {
            case R.id.back_update:
                if (compoundButton.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                    editor.putBoolean("back_update", true);
                    editor.commit();
                    update_frequency.setEnabled(true);
                    Intent intent = new Intent(this, AutoUpdateService.class);
                    switch (prefs.getInt("update_frequency", 2)) {
                        case 0:
                            intent.putExtra("anHour", 1);
                            break;
                        case 1:
                            intent.putExtra("anHour", 2);
                            break;
                        case 2:
                            intent.putExtra("anHour", 5);
                            break;
                        case 3:
                            intent.putExtra("anHour", 8);
                            break;
                        default:
                            break;
                    }
                    startService(intent);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                    editor.putBoolean("back_update", false);
                    editor.commit();
                    update_frequency.setEnabled(false);
                    Intent intent = new Intent(this, AutoUpdateService.class);
                    stopService(intent);
                }
                break;
            default:
                break;
        }
    }

