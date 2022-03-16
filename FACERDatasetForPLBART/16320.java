    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 400:
                mainTvPermission.setText("欢迎使用...");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainTvPermission.setVisibility(View.GONE);
                        showFragment(1);
                    }
                }, 2000);
                break;
            default:
                mainTvPermission.setText("没有必�?的�?��?，无法进入系统。");
                break;
        }
    }

