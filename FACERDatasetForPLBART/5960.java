    private void ShowDetial(int position) {
        File file = mDatas.get(position);
        String size = FileUtils.getFileSize(file);
        String name = file.getName();
        String path = file.getAbsolutePath();
        String time = TimeUtils.milliseconds2String(file.lastModified());

        //获�?�图片宽高
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options); // 此时返回的bitmap为null
        int width = options.outWidth;
        int height = options.outHeight;


        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("文件属性")
                .setCancelable(false)
                .setNegativeButton("确定", null)
                .setMessage("\n" + "文件�??：" + name + "\n\n" + "文件大�?：" + size + "\n\n" + "文件路径：" +
                        path + "\n\n" + "时间：" + time + "\n\n" + "图片分辨率：" + width + "*" + height)
                .show();

    }

