    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.general_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);

        Resources res = getResources();
        linkTextColour = res.getColor(LINKS_COLOUR);

        TextView aboutTextView_1 = (TextView) findViewById(R.id.about_textview_part_1);
        final SpannableString s1 = new SpannableString(getAboutTextPart_1());
        Linkify.addLinks(s1, Linkify.WEB_URLS | Linkify.EMAIL_ADDRESSES);
        displayTextWithLinks(aboutTextView_1, s1);

        TextView aboutTextView_2 = (TextView) findViewById(R.id.about_textview_part_2);
        final SpannableString s2 = new SpannableString(getAboutTextPart_2());
        Linkify.addLinks(s2, Linkify.WEB_URLS);
        displayTextWithLinks(aboutTextView_2, s2);
    }

