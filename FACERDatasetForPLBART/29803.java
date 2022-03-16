    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        ButterKnife.bind(this);
        libID = getIntent().getExtras().getInt(Constants.LIBRARY_ID);

        switch (libID)
        {
            case 1:
            {
                library = getString(R.string.lib_1);
                license = getString(R.string.lib_1_license) + getString(R.string.mit_license);
                link = getString(R.string.lib_1_link);
                break;
            }
            case 2:
            {
                library = getString(R.string.lib_2);
                license = getString(R.string.lib_2_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_2_link);
                break;
            }
            case 4:
            {
                library = getString(R.string.lib_4);
                license = getString(R.string.lib_4_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_4_link);
                break;
            }
            case 5:
            {
                library = getString(R.string.lib_5);
                license = getString(R.string.lib_5_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_5_link);
                break;
            }
            case 6:
            {
                library = getString(R.string.lib_6);
                license = getString(R.string.lib_6_license) + getString(R.string.mit_license);
                link = getString(R.string.lib_6_link);
                break;
            }
            case 7:
            {
                library = getString(R.string.lib_7);
                license = getString(R.string.lib_7_license) + getString(R.string.mit_license);
                link = getString(R.string.lib_7_link);
                break;
            }
            case 8:
            {
                library = getString(R.string.lib_8);
                license = getString(R.string.lib_8_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_8_link);
                break;
            }
            case 9:
            {
                library = getString(R.string.lib_9);
                license = getString(R.string.lib_9_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_9_link);
                break;
            }
            case 10:
            {
                library = getString(R.string.lib_10);
                license = getString(R.string.lib_10_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_10_link);
                break;
            }
            case 11 :
            {
                library = getString(R.string.lib_11);
                license = getString(R.string.lib_11_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_11_link);
                break;
            }
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(library);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fab.setImageDrawable(new IconicsDrawable(this)
                            .icon(MaterialDesignIconic.Icon.gmi_github)
                            .color(Color.WHITE));
        licText.setText(Html.fromHtml(license));
    }

