    private void initView() {

        LayoutInflater.from(getContext()).inflate(R.layout.layout_title_view, this, true);
        this.setOrientation(VERTICAL);
        this.setBackgroundColor(titleBackgroundColor);

        TextView titleTextView = (TextView) findViewById(R.id.title_text_view);
        titleTextView.setText(title);
//        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);

        View view = findViewById(R.id.title_line_view);
        view.setBackgroundColor(titleLineColor);
    }

