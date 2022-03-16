    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Context context = inflater.getContext();

        final View view = inflater.inflate(R.layout.fragment_save, container, false);

        final ImageView icon = (ImageView) view.findViewById(android.R.id.icon);
        icon.setImageDrawable(
                IconUtils.loadMimeIcon(context, getArguments().getString(EXTRA_MIME_TYPE)));

        mDisplayName = (EditText) view.findViewById(android.R.id.title);
        mDisplayName.addTextChangedListener(mDisplayNameWatcher);
        mDisplayName.setText(getArguments().getString(EXTRA_DISPLAY_NAME));

        mSave = (Button) view.findViewById(android.R.id.button1);
        mSave.setOnClickListener(mSaveListener);
        mSave.setEnabled(false);

        mProgress = (ProgressBar) view.findViewById(android.R.id.progress);

        return view;
    }

