    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_file_view, container, false);
        setRetainInstance(true);

        loadListDirectory();
        loadDirectoryNavigation();
        return view;
    }

