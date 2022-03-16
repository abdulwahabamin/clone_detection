    public static List<File> getSpecificTypeOfFile(Context context, String[] extension) {
        List<String> fileUrls = new ArrayList<>();

        //从外存中获�?�
        Uri fileUri = MediaStore.Files.getContentUri("external");
        //筛选列，这里�?�筛选了：文件路径和�?�?��?�缀的文件�??
        String[] projection = new String[]{
                MediaStore.Files.FileColumns.DATA, MediaStore.Files.FileColumns.TITLE
        };
        //构造筛选语�?�
        String selection = "";
        for (int i = 0; i < extension.length; i++) {
            if (i != 0) {
                selection = selection + " OR ";
            }
            selection = selection + MediaStore.Files.FileColumns.DATA + " LIKE '%" + extension[i] + "'";
        }
        //按时间递增顺�?对结果进行排�?;待会从�?�往�?移动游标就�?�实现时间递�?
        String sortOrder = MediaStore.Files.FileColumns.DATE_MODIFIED;
        //获�?�内容解�?器对象
        ContentResolver resolver = context.getContentResolver();
        //获�?�游标
        Cursor cursor = resolver.query(fileUri, projection, selection, null, sortOrder);
        if (cursor == null)
            return null;
        //游标从最�?�开始往�?递�?，以此实现时间递�?顺�?（最近访问的文件，优先显示）
        if (cursor.moveToLast()) {
            do {
                //输出文件的完整路径
                String data = cursor.getString(0);
                Log.d("tag", data);
                fileUrls.add(data);

            } while (cursor.moveToPrevious());
        }
        cursor.close();
        List<File> rets = new ArrayList<>();
        for (int i = 0; i < fileUrls.size(); i++) {
            File file = new File(fileUrls.get(i));
            rets.add(file);
        }
        Log.d("ccccccc", "getSpecificTypeOfFile: " + rets.size());
        return rets;
    }

