    /**
     * Construct a JSONArray from a Collection.
     *
     * @param collection
     *            A Collection.
     */
    public JSONArray(Collection collection) {
        this.myArrayList = new ArrayList();
        if (collection != null) {
            Iterator iter = collection.iterator();
            while (iter.hasNext()) {
                this.myArrayList.add(JSONObject.wrap(iter.next()));
            }
        }
    }

