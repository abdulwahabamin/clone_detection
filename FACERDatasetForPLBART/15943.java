    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_connectivity_home, container, false);
        Button button =(Button) parentView.findViewById(R.id.join_group_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinGroup(v);
            }
        });
        button = (Button) parentView.findViewById(R.id.create_group_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGroup(v);
            }
        });

        SharedPreferences preferences =
                getContext().getSharedPreferences(Global.SHARED_PREFS_NAME, Context.MODE_PRIVATE);

        String lastUsername = preferences.getString(ConnectivityFragment.LAST_USED_USERNAME_KEY, null);

        if(lastUsername != null) {
            ((EditText) parentView.findViewById(R.id.username)).setText(lastUsername);
        }

        return parentView;
    }

