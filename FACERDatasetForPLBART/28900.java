    /**
     * Constructor.
     *
     * @param context  The context of the HTTP request.
     */
    public ProcessOwmAddCityRequest(Context context) {
        this.context = context;
        this.dbHelper = PFASQLiteHelper.getInstance(context);
    }

