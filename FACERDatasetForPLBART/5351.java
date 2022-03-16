    private List<FileDirectory> getAllMediaPath(Activity activity, FlowableEmitter<List<FileDirectory>> e,int selection) {
        Uri uri=null;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        List<FileDirectory> list = new ArrayList<>();
        String absolutePathOfImage, fileName;
        String[] projection={};
        if(selection==AUDIO) {
            uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            projection=new String[]{ MediaStore.MediaColumns.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME};
            Log.e("Test","Audio");
        }else if(selection==IMAGES){
            uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            projection = new String[]{ MediaStore.MediaColumns.DATA,
                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME };
            Log.e("Test","Images");
        }else if(selection==VIDEO){
            uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            projection = new String[]{ MediaStore.Video.VideoColumns.DATA ,
                    MediaStore.Video.Media.DISPLAY_NAME};
            Log.e("Test","Video");
        }

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(projection[0]);
        column_index_folder_name = cursor.getColumnIndexOrThrow(projection[1]);
        cursor.moveToFirst();

        do{
            absolutePathOfImage = cursor.getString(column_index_data);
            fileName=cursor.getString(column_index_folder_name);
            if(!new File(absolutePathOfImage).exists())
                continue;
            list.add(new FileDirectory(fileName,FileDirectory.FILE,
                fileEx.getAbsoluteFileSize(absolutePathOfImage),
                    fileEx.getAbsoluteInfo(absolutePathOfImage),absolutePathOfImage));
            e.onNext(list);
        }while (cursor.moveToNext());

        return list;
    }

