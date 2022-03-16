    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTheme(R.style.DayTheme);
        if (MyApplication.nightMode2()) {
            initNightView(R.layout.night_mode_overlay);
        }
        View view = inflater.inflate(R.layout.fragment_share, container, false);
        files[0] = new File(MyApplication.getAppContext().getExternalFilesDir(null),
                "IMG-BRIEF"  + ".png");
        files[1] = new File(MyApplication.getAppContext().getExternalFilesDir(null),
                "IMG-DETAIL" + ".png");
        files[2] = new File(MyApplication.getAppContext().getExternalFilesDir(null),
                "IMG-FUTURE"  + ".png");
        initView(view);
        return view;
    }

