    /**
     * �?存图片到SD�?�指定目录
     *
     * @param pBitmap
     * @param strName
     * @return
     */
    private static boolean savePic(Bitmap pBitmap, String strName) {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strName);
            if (null != fos) {
                pBitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
                return true;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

