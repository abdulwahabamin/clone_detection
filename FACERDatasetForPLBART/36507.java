    private void findView() {
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        titleText = (TextView) findViewById(R.id.title_text);
        listView = (ListView) findViewById(R.id.list_view);
    }

