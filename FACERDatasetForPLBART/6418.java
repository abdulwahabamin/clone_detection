    public static void writeNullableString(DataOutputStream out, String value) throws IOException {
        if (value != null) {
            out.write(1);
            out.writeUTF(value);
        } else {
            out.write(0);
        }
    }

