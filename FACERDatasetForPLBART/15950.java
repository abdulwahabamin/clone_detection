    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_create_group, container, false);

        groupCreationStatus = group.getCreationStatus();

        switch (groupCreationStatus) {
            case GROUP_NOT_CREATED:
                rootView.findViewById(R.id.create_group).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createGroup(v);
                    }
                });
                break;
            case GROUP_WAITING_FOR_CREATION:
                onWaitingForGroupCreation();
                break;
            case GROUP_CREATED:
                onGroupCreated();
                break;
        }

        SharedPreferences preferences =
                getContext().getSharedPreferences(Global.SHARED_PREFS_NAME, Context.MODE_PRIVATE);

        String lastGroupName = preferences.getString(ConnectivityFragment.LAST_USED_GROUP_NAME_KEY, null);

        if(lastGroupName != null) {
            ((EditText) rootView.findViewById(R.id.group_name)).setText(lastGroupName);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                ShareGroup.shareGroupWeakReference.get().getMemberList());
        ((ListView)rootView.findViewById(R.id.peer_list)).setAdapter(adapter);

        rootView.findViewById(R.id.close_connection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeConnection();
            }
        });

        return rootView;
    }

