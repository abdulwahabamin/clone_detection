    public ControllerFragment(MainViewFragment mainViewFragment) {
        this.mainViewFragment = mainViewFragment;
        this.fileManagerCore = new FileManagerCore();
        this.listFiles = new ArrayList<>();
        init();
    }

