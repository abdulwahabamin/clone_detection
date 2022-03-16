    public DownloadedItemAdapter(Context context, int textViewResourceId, List<Music> musicArrayList) {
        super(context, textViewResourceId, musicArrayList);
        this.filteredMusicArrayList = musicArrayList;   //Filtered Music List --- By default it has all the fetched records
        this.musicArrayList = new ArrayList<Music>();   //Original Music List --- Without search applied
        this.musicArrayList.addAll(musicArrayList);     //Copying all the values to the Original list
        dbHandler = DBHandler.getInstance(context);
    }

