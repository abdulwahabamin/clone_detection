    public LocationsRecyclerAdapter(Context context, ArrayList<Weather> weatherArrayList, boolean darkTheme, boolean blackTheme) {
        this.context = context;
        this.weatherArrayList = weatherArrayList;
        this.darkTheme = darkTheme;
        this.blackTheme = blackTheme;

        inflater = LayoutInflater.from(context);
    }

