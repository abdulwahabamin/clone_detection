    @Override
    public void initView() {
        toolbar.setTitle(tag + "的百度百科");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true); //设置返回键�?�用
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        progressBar.setMax(100);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl(link);
    }

