    public IndexerFile(long id,String filename, String filePath, int category, long size, int icontype, long modified) {
        bean = new JSONObject();
        bean.put(LONG_ID,id);
        bean.put(STRING_FILENAME,filename);
        bean.put(STRING_FILEPATH,filePath);
        bean.put(INT_CATEGORY,category);
        bean.put(LONG_FILESIZE,size);
        bean.put(INT_ICONTYPE,icontype);
        bean.put(LONG_MODIFIED,modified);

    }

