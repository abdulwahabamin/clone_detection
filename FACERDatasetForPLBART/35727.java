    /**
     * 导入城市数�?�库
     */
    public static void importCityDB() {

        // 判断�?�?城市的数�?�库文件是�?�存在
        File file = new File(WeatherApplication.getInstance().getDatabasePath(DATABASE_NAME).getAbsolutePath());
        if (!file.exists()) {// 如果�?存在，则导入数�?�库文件
            //数�?�库文件
            File dbFile = WeatherApplication.getInstance().getDatabasePath(DATABASE_NAME);
            try {
                if (!dbFile.getParentFile().exists()) {
                    dbFile.getParentFile().mkdir();
                }
                if (!dbFile.exists()) {
                    dbFile.createNewFile();
                }
                //加载欲导入的数�?�库
                InputStream is = WeatherApplication.getInstance().getResources().openRawResource(R.raw.city);
                FileOutputStream fos = new FileOutputStream(dbFile);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                fos.write(buffer);
                is.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

