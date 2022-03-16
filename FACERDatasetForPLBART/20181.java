    public static SingleLicenseDialogFragment newInstance(final Notice notice) {
        final SingleLicenseDialogFragment fragment = new SingleLicenseDialogFragment();
        final Bundle args = new Bundle();
        args.putSerializable(ARGUMENT_NOTICE, notice);
        fragment.setArguments(args);
        return fragment;
    }

