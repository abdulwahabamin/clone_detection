    @Override
    public void onCreate() {
        super.onCreate();

        //pass the App instance inside @Component.Builder method so that Dagger can bind it to App type
        appComponent = DaggerAppComponent.builder().providesApp(this).build();
    }

