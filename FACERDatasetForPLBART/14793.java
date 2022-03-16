    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.playlist_layout, container, false);

        fragmentCommunicator = (FragmentCommunicator) getActivity();
        playlistCovers = new ArrayList<>();
        playlistMap = new HashMap<>();
        imgs = getResources().obtainTypedArray(R.array.image_ids);
        bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(0, -1));


        gridView = (GridView) view.findViewById(R.id.gridView);
        addPlaylistButton = (FloatingActionButton) view.findViewById(R.id.addPlaylistButton);

        gridAdapter = new GridViewAdapter(getActivity(), R.layout.grid_item_layout, playlistCovers);
        gridView.setAdapter(gridAdapter);

        loadPlaylists();

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fragmentCommunicator.setPlaylistTitle(playlistCovers.get(i).getTitle());

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down, R.anim.slide_up, R.anim.slide_down);

                fragmentTransaction.replace(R.id.playlist_layout, playlistMusicListFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                fragmentCommunicator.setPlaylistTitle(playlistCovers.get(i).getTitle());
                PopupMenu popupMenu = new PopupMenu(getActivity(), gridView);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity()).setTitle("Delete Playlist");
                        alertBuilder.setMessage("Are you sure you want to delete playlist?");

                        alertBuilder.setCancelable(true).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int num) {
                                deletePlaylist(fragmentCommunicator.getPlaylistTitle(), i);
                            }
                        });

                        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                        Dialog dialog = alertBuilder.create();
                        dialog.show();

                        return true;
                    }
                });

                popupMenu.show();

                return true;
            }
        });

        addPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = (LayoutInflater.from(getActivity())).inflate(R.layout.user_input, null);
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity()).setTitle("Create Playlist");
                alertBuilder.setView(dialogView);
                final EditText userInput = (EditText) dialogView.findViewById(R.id.userInput);

                alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), userInput.getText() + " Playlist Created!", Toast.LENGTH_LONG).show();
                        playlistMap.put(userInput.getText().toString(), new ArrayList<File>());
                        fragmentCommunicator.savePlaylistHashMap(playlistMap);
                        addToPlaylistList(userInput.getText().toString());
                    }
                });

                alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                Dialog dialog = alertBuilder.create();
                dialog.show();
            }
        });

        return view;
    }

