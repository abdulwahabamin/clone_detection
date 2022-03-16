    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (jsonStringsForChildFragments.size() == 0) {
            TextView textView = new TextView(parentActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            textView.setText(R.string.error_message_no_data);
            textView.setTextSize(getResources().getDimensionPixelSize(R.dimen.text_size_large));
            return textView;
        }
        View view = inflater.inflate(R.layout.sliding_tab_host, container, false);
        PagerSlidingTabStrip pagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(
                R.id.tabs);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        WeatherForecastPagerAdapter pagerAdapter = new WeatherForecastPagerAdapter(
                parentActivity.getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        pagerSlidingTabStrip.setViewPager(viewPager);

        return view;
    }

