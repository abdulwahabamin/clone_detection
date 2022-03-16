    @Override
    protected ArrayList<File> doInBackground(Integer... params) {
        int total=0;
        data = new ArrayList<>();
        searchfilemap = new HashMap<>();

          searchByPath(path);

        if (searchfilemap.size() > 0) {
            //å?–å‡ºmapä¸­æ•°æ?®ï¼Œèµ‹å€¼ç»™data
            Object[] list = searchfilemap.entrySet().toArray();
            for (int i = 0; i < searchfilemap.size(); i++) {
                data.add(new File(list[i].toString()));
            }
        }
        return data;
    }

