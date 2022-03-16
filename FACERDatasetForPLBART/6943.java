    public static ArrayList<String> getSpecificTypeOfFile(Context context,String[] extension){
        ArrayList<String> filePaths=new ArrayList<String>();
        Uri fileUri= MediaStore.Files.getContentUri("external");
        String[] projection=new String[]{
                FileColumns.DATA,FileColumns.TITLE
        };
        String selection="";
        for(int i=0;i<extension.length;i++){
            if(i!=0){
                selection=selection+" OR ";
            }
            selection=selection+FileColumns.DATA+" LIKE '%"+extension[i]+"'";
        }
        String sortOrder=FileColumns.DATE_MODIFIED;
        ContentResolver resolver=context.getContentResolver();
        Cursor cursor=resolver.query(fileUri,projection,selection,null,sortOrder);
        if(cursor==null){
            return filePaths;
        }
        if(cursor.moveToLast()){
            do {
                String data=cursor.getString(0);
                filePaths.add(data);
                Log.d("tag",data);
            }while (cursor.moveToPrevious());
        }
        cursor.close();
        return filePaths;
    }

