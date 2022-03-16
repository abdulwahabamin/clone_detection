    /**
     * Constructor.
     *
     * @param context  The context in which the AutoCompleteTextView is to be used.
     * @param dbHelper An instance of a DatabaseHelper. This object is used to make the database
     *                 queries.
     */
    public AutoCompleteCityTextViewGenerator(Context context, PFASQLiteHelper dbHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
    }

