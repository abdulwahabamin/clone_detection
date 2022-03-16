    public static ContainerPagerFragment newInstance(final File file) {
        Bundle args = new Bundle();
        ContainerPagerFragment fragment = new ContainerPagerFragment();
        args.putString(BUNDLE_ARGS_CURRENT_PATH, file.getAbsolutePath());
        fragment.setArguments(args);
        return fragment;
    }

