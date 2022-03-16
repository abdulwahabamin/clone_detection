    private void findView() {
        welcome_start = (Button) findViewById(R.id.welcome_start);
        welcome_start.setOnClickListener(this);
        welcome_page = (ViewFlipper) findViewById(R.id.welcome_page);
        welcome_page.setOnTouchListener(this);
    }

