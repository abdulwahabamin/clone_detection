    public static LicensesDialogFragment newInstance(final int rawNoticesResourceId, final boolean includeOwnLicense) {
        final LicensesDialogFragment licensesDialogFragment = new LicensesDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARGUMENT_NOTICES_XML_ID, rawNoticesResourceId);
        args.putBoolean(ARGUMENT_INCLUDE_OWN_LICENSE, includeOwnLicense);
        licensesDialogFragment.setArguments(args);
        return licensesDialogFragment;
    }

