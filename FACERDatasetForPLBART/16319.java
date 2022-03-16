    @PermissionNo(520)
    private void getPermissionNo(List<String> deniedPermissions) {
        mainTvPermission.setText("没有必�?的�?��?，无法进入系统。");
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
            AndPermission.defaultSettingDialog(this, 400)
                    .setTitle("�?��?申请失败")
                    .setMessage("您拒�?了必�?的�?��?，已�?无法正常愉快的玩�?了，请在设置中手动授�?��?")
                    .setPositiveButton("好，去设置")
                    .show();
        }
    }

