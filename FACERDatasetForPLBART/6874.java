    public void ActivityAfterGrantingPermissions()
    {
        setContentView(R.layout.activity_main);
        snackBarList = new ArrayList<>();
        navigationViewMenuArray = new ArrayList<>();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            current_path = Environment.getExternalStorageDirectory().getPath();
            active_window = 1;
            current_path_first_window = current_path;
            current_path_second_window = current_path;
        } else {
            Snackbar.make(findViewById(android.R.id.content), "Storage is not mounted. Exiting...", Snackbar.LENGTH_SHORT).show();
            finish();
        }
        list = (ListView) findViewById(R.id.List);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.Drawer);
        navigationView = (NavigationView) findViewById(R.id.Navigation);
        registerForContextMenu(list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationViewMenuArray = showAllStorages();
        Menu navigationViewMenu = navigationView.getMenu();
        for (String item:navigationViewMenuArray)
        {
            navigationViewMenu.add(item).setIcon(R.drawable.ic_sd_card_white_24dp);
        }
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                current_path = "/storage/" + item.getTitle().toString().substring(0, item.getTitle().toString().lastIndexOf(" "));
                updateList();
                drawerLayout.closeDrawers();
                Snackbar.make(findViewById(android.R.id.content), "You have changed storage to " + item.getTitle(), Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });
        updateList();
        showQueuedSnackBar(findViewById(android.R.id.content), "You can change current window by touching MENU button", Snackbar.LENGTH_SHORT);
        showQueuedSnackBar(findViewById(android.R.id.content), "Current active window is " + active_window, Snackbar.LENGTH_SHORT);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                File check = new File(current_path + "/" + list.getItemAtPosition(i).toString());
                if (check.isDirectory()) {
                    current_path = current_path + "/" + list.getItemAtPosition(i).toString();
                    updateList();
                }
            }
        });
    }

