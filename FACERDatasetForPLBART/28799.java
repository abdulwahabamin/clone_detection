    /**
     * Constructor.
     */
    public RecyclerOverviewListAdapter(Context context, List<CityToWatch> cities) {
        this.context = context;
        this.cities = cities;
        prefManager = new PrefManager(context);
        database = PFASQLiteHelper.getInstance(context);
    }

