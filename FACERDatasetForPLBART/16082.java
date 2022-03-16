    private Library(Context context) {
        File databaseFile = new File(DATABASE_LOCATION, LOCAL_DATABASE_NAME);
        openHelper = new LibraryDbOpenHelper(context, databaseFile);
        dbFile = databaseFile;
        this.context = context;

        //fill both Table arrays with same Table types and in the same order! This is used by the library get and send methods.
        tables = new Table[]{
                new SongTable(context.getContentResolver()),
                new AlbumTable(context.getContentResolver()),
                new ArtistTable(context.getContentResolver())
        };

        remoteTables = new Table[] {
                new SongTable(null),
                new AlbumTable(null),
                new ArtistTable(null)
        };
    }

