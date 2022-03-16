    private void init() {
        name= (EditText) findViewById(R.id.ed_name);
        edit= (ImageButton) findViewById(R.id.btn_edit);
        save= (Button) findViewById(R.id.btn_save);
        container_save = (LinearLayout) findViewById(R.id.ll_save);
        current_name= BlueHelper.getBluetoothAdapter().getName();
        name.setText(current_name);

        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

