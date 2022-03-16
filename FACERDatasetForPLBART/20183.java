    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources resources = getResources();

        if (savedInstanceState != null) {
            mTitleText = savedInstanceState.getString(STATE_TITLE_TEXT);
            mLicenseText = savedInstanceState.getString(STATE_LICENSE_TEXT);
            mCloseButtonText = savedInstanceState.getString(STATE_CLOSE_TEXT);
        } else {
            mTitleText = resources.getString(R.string.notices_title);
            mCloseButtonText = resources.getString(R.string.notices_close);

            try {
                final Notice notice = getNotice();
                mLicenseText = NoticesHtmlBuilder.create(getActivity()).setNotice(notice).build();
            } catch (final Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

