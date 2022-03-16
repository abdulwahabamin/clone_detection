    public static String SceneList2String(HashMap<String, Integer> hashmap)
            throws IOException {
        // 实例化一个ByteArrayOutputStream对象，用�?�装载压缩�?�的字节文件。
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 然�?�将得到的字符数�?�装载到ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                byteArrayOutputStream);
        // writeObject 方法负责写入特定类的对象的状�?，以便相应的 readObject 方法�?�以还原它
        objectOutputStream.writeObject(hashmap);
        // 最�?�，用Base64.encode将字节文件转�?��?Base64编�?�?存在String中
        String SceneListString = new String(Base64.encode(
                byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        // 关闭objectOutputStream
        objectOutputStream.close();
        return SceneListString;
    }

