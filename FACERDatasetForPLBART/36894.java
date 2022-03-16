    private void pickImage(final ImageUtils.PickType type) {
        if (!FileUtils.hasSDCard()) {
            SnackbarUtils.show(this, R.string.no_sdcard);
            return;
        }

        PermissionReq.with(this)
                .permissions(Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .result(new PermissionReq.Result() {
                    @Override
                    public void onGranted() {
                        ImageUtils.pickImage(ImageWeatherActivity.this, type);
                    }

                    @Override
                    public void onDenied() {
                        SnackbarUtils.show(ImageWeatherActivity.this, "没有获�?�手机信�?��?��?，无法上传实景�?");
                    }
                })
                .request();
    }

