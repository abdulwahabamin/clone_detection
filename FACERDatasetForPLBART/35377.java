    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(isQuit[0]){
                finish();
            }else{
                showToast("æ˜¯å?¦è¦?é€€å‡º");
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

