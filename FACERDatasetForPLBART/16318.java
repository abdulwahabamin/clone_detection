    @PermissionYes(520)
    private void getPermissionYes(List<String> grantedPermissions) {
        mainTvPermission.setText("欢迎使用...");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainTvPermission.setVisibility(View.GONE);
                showFragment(1);
            }
        }, 2000);
    }

