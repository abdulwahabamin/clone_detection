    private void findView() {
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText("设置");

        update_frequency = (Spinner) findViewById(R.id.update_frequency);
        adapter = new ArrayAdapter<>(this, R.layout.spinner_item, frequency);
        update_frequency.setAdapter(adapter);
        SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
        update_frequency.setSelection(prefs.getInt("update_frequency", 1), true);
        update_frequency.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                SharedPreferences.Editor editor = getSharedPreferences("data_setting", MODE_PRIVATE).edit();
                editor.putInt("update_frequency", arg2);
                editor.commit();
                Intent intent = new Intent(SettingActivity.this, AutoUpdateService.class);
                intent.putExtra("anHour", ((TextView) arg1).getText().charAt(0) - 48);
                startService(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        back_update = (Switch) findViewById(R.id.back_update);
        back_update.setOnCheckedChangeListener(this);
        if (prefs.getBoolean("back_update", true)) {
            back_update.setChecked(true);
            update_frequency.setEnabled(true);
        } else {
            back_update.setChecked(false);
            update_frequency.setEnabled(false);
        }
    }

