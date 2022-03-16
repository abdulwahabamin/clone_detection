    private void findView() {
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText("å??é¦ˆ");
        feed_back = (WebView) findViewById(R.id.web_view);
        feed_back.getSettings().setJavaScriptEnabled(true);
        feed_back.setWebViewClient(new WebViewClient());
        feed_back.loadUrl("http://form.mikecrm.com/Vgc2aM");
    }

