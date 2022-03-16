    private JSONArray getSelectedFilesAsJSONArray() {
        JSONArray jarr = new JSONArray();
        Iterator<String> it = fm.getSelectedFiles().keySet().iterator();
        while (it.hasNext()) {
            String pairs = (String)it.next();
            jarr.put(pairs);
            //it.remove(); // avoids a ConcurrentModificationException
        }
        return jarr;
    }

