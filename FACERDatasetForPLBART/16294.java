    private ArrayList<HashMap<String, Object>> initData() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map;
        for (int i = 0; i < options.length; i++) {
            map = new HashMap<>();
            map.put("option", options[i]);
            map.put("icon", icons[i]);
            list.add(map);
        }
        return list;
    }

