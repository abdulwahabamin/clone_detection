    public void ParseData(String in){
        try {
            reader = new JSONObject(in);
            this.list  = reader.getJSONArray("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

