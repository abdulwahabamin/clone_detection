    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {//当webview�?是处于第一页�?�时，返回上一个页�?�
                webView.goBack();
                return true;
            }else {//当webview处于第一页�?�时,直接退出程�?
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

