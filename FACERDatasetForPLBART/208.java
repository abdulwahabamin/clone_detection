    private void initPreData() {
        device = getIntent().getParcelableExtra("device");

        uuid = getIntent().getStringExtra("uuid");

        if (uuid == null) {
            isClient = false;
        } else {
            isClient = true;
        }

        if (device == null) {
            Toast.makeText(this, "对方已�?退出连接!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

