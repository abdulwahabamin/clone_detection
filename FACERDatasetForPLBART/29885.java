    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first_launch, container, false);
        preferences = new Prefs(getContext());
        cityInput = rootView.findViewById(R.id.city_input);
        textField = rootView.findViewById(R.id.materialTextField);
        ImageView img = textField.findViewById(R.id.mtf_image);
        img.setImageAlpha(R.drawable.logo);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permission = new Permissions(getContext());
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION} , Constants.READ_COARSE_LOCATION);
            }
        });
        message = rootView.findViewById(R.id.intro_text);
        if (GlobalActivity.i == 0) {
            message.setText(getString(R.string.pick_city));
        }
        else {
            message.setText(getString(R.string.uh_oh));
        }
        Button goButton = rootView.findViewById(R.id.go_button);
        goButton.setText(getString(android.R.string.ok));
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!new CheckConnection(getContext()).isNetworkAvailable()) {
                    Snackbar.make(rootView , getString(R.string.check_internet) , Snackbar.LENGTH_SHORT).show();
                }
                else if (cityInput.getText().length() > 0) {
                    launchActivity(0);
                }
                else {
                    Snackbar.make(rootView , getString(R.string.enter_city_first) , Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        cityInput.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    launchActivity(0);
                    return true;
                }
                return false;
            }
        });
        return rootView;
    }

