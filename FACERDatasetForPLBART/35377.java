    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(isQuit[0]){
                finish();
            }else{
                showToast("是�?��?退出");
                isQuit[0] = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isQuit[0] = false;
                    }
                },2000);
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

