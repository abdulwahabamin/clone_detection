    /**
     * 传入欲分享的图片的路径�?无法分享图片时的替代文本以�?�Context对象， 最�?�调用系统接�?�实现分享, 注�?：需�?设置文件读写�?��?
     *
     * @param imgPath
     * @param text
     * @param context
     */
    public static void share(String imgPath, String text, Context context) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        if (imgPath == null) {
            // 仅分享文本信�?�
            shareIntent.setType("text/plain");
        } else {
            // 分享图片信�?�
            File f = new File(imgPath);
            Uri uri = Uri.fromFile(f);
            if (uri != null && imgPath != null && imgPath != "") {
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setType("image/png");
                // 当用户选择短信时使用sms_body�?�得文字
                shareIntent.putExtra("sms_body", text);
            } else {
                shareIntent.setType("text/plain");
            }
        }

        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        // 自定义选择框的标题
        context.startActivity(Intent.createChooser(shareIntent, "选择分享方�?"));
    }

