    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getInstrumentation().getTargetContext(), AboutActivity.class);
        startActivity(intent, null, null);
        aboutActivity = getActivity();
        aboutTextView_1 = (TextView) aboutActivity.findViewById(com.haringeymobile.ukweather.R.id.
                about_textview_part_1);
        aboutTextView_2 = (TextView) aboutActivity.findViewById(com.haringeymobile.ukweather.R.id.
                about_textview_part_2);
    }

