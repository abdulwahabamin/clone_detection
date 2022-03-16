    public static String readNullableString(DataInputStream in) throws IOException {
        if (in.read() != 0) {
            return in.readUTF();
        } else {
            return null;
        }
    }

