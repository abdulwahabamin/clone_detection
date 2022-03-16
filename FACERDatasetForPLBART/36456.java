    private void gotoMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        // 修�? Android 9.0 下 Activity 跳转动画导致的�?�动页闪�?的问题
        overridePendingTransition(0, 0);
        finish();
    }

