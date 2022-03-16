    @Override
    public void onResume() {
        super.onResume();

        Intent intent = getIntent();
        //Uri data = intent.getData();
        Bundle data=intent.getBundleExtra(INTENT_DATE_STACKTRACE);
        if (data != null) {
            //BLog.e("COMPOSE", " -- " + data.toString());
            //String launchUri = data.toString();
            Toast.makeText(this,"App Caught crash",Toast.LENGTH_LONG);

        }





        String locale = getResources().getConfiguration().locale.getDisplayCountry();
        //Log.e("LOCALE", "Main.onResume() : " + locale);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        //this.getActionBar().getCustomView().setFitsSystemWindows(true);
        if(isCreateStart) {
            //Log.e("MAIN", "CREATE START tested as TRUE !!");
            if(Device.isMediaMounted()) {
                Bgo.openCurrentState(this);
            } else {
                checkSdCard();
            }

        } else if(isRestart) {
            //Log.e("MAIN", "RESTART tested as TRUE !!");
            //throw new NullPointerException("Manually created exception");
            //Bgo.openCurrentState(this);
        }
        isCreateStart=false;
        isRestart=false;


    }

