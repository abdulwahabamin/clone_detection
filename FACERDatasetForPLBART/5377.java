    public static DocumentFile getDocumentFile(Context c,String path,String name,Uri baseTreeUri){

        DocumentFile documentFile=DocumentFile.fromTreeUri(c,baseTreeUri);
        Log.e(TAG,"base tree uri: "+baseTreeUri.toString());
        if(path.equals(""))
            return documentFile;
        String[] dirs=path.split("/");
        for(String dir:dirs){
            documentFile=documentFile.findFile(dir);
        }
        if(name==null)
            return documentFile;
        return documentFile.findFile(name);
    }

