    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity(), R.style.RhythmAlertDialog);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.dialog_fragment, null);
        dialogBuilder.setView(dialogView);
        mylist = (ListView) dialogView.findViewById(R.id.list);
        listItems = getArguments().getStringArray("playlistNames");

        dialogBuilder.setTitle("Choose Playlist");

        return dialogBuilder.create();

    }

