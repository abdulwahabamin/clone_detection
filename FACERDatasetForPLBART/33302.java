    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_add_city, null);

        queryEditText = (EditText) view.findViewById(R.id.ac_search_edit_text);
        TextView infoTextView = (TextView) view.findViewById(R.id.ac_info_text_view);
        infoTextView.setText(MiscMethods.getNoCitiesFoundDialogMessage(getResources()));

        ImageButton searchButton = (ImageButton) view.findViewById(R.id.ac_search_button);
        TypedValue outValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.themed_round_drawable, outValue, true);
        searchButton.setBackgroundResource(outValue.resourceId);
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onNewCityQuerySubmitted();
            }

        });

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setIcon(R.drawable.ic_add_content)
                .setTitle(R.string.dialog_title_add_city)
                .create();
    }

