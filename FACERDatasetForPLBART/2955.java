    private void CheckOpen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                startActivity(new Intent(MainActivity.this,FileActivity.class));
                finish();
            }
        }).start();
    }

