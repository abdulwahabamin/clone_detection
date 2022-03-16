    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exit) > 2000) {
            Toast.makeText(this, "�?按一次退出", Toast.LENGTH_SHORT).show();
            exit = System.currentTimeMillis();
        } else {
            finish();
        }
    }

