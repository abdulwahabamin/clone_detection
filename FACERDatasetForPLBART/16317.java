    private void checkPermission() {
        mainTvPermission.setText("我需�?扫�??音�?文件，请授予我�?��?。");
        AndPermission.with(this)
                .requestCode(520)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .callback(this)
                .start();
    }

