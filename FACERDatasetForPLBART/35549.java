    public static <T>  T convertObject(byte[] bytes, Class<T> clz) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            Object object = new ObjectInputStream(bais).readObject();
            T t = clz.cast(object);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

