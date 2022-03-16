    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources resources = getResources();

        if (savedInstanceState != null) {
            mTitleText = savedInstanceState.getString(STATE_TITLE_TEXT);
            mLicensesText = savedInstanceState.getString(STATE_LICENSES_TEXT);
            mCloseButtonText = savedInstanceState.getString(STATE_CLOSE_TEXT);
        } else {
            mTitleText = resources.getString(R.string.notices_title);
            mCloseButtonText = resources.getString(R.string.notices_close);
            try {
                final Notices notices = NoticesXmlParser.parse(resources.openRawResource(getNoticesXmlResourceId()));
                if(getArguments() != null && getArguments().getBoolean(ARGUMENT_INCLUDE_OWN_LICENSE, false)) {
                    notices.getNotices().add(LicensesDialog.LICENSES_DIALOG_NOTICE);
                }
                mLicensesText = NoticesHtmlBuilder.create(getActivity()).setNotices(notices).build();
            } catch (final Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

