    private static String getLyricsMP4(File file) throws Exception {
        FileInputStream in = new FileInputStream(file);

        byte head[] = new byte[4];
        in.read(head);
        int len = byteArrayToInt(head);
        in.read(head);
        if (!Arrays.equals(head, new byte[]{'f', 't', 'y', 'p'})) {
            in.close();
            return null;
        }
        in.skip(len - 8);
        final byte path[][] = new byte[][]{{'m', 'o', 'o', 'v'}, {'u', 'd', 't', 'a'}, {'m', 'e', 't', 'a'}, {'i', 'l', 's', 't'}, {(byte) '©', 'l', 'y', 'r'}, {'d', 'a', 't', 'a'}};
        int atom_size = Integer.MAX_VALUE;
        outter:
        for (byte[] atom : path) {
            while (in.available() > 0) {
                byte buffer[] = new byte[4];
                in.read(buffer);
                len = byteArrayToInt(buffer);
                if (len == 0) continue;
                in.read(buffer);
                if (len > atom_size) {
                    in.close();
                    return null;
                }
                if (Arrays.equals(buffer, atom)) {
                    atom_size = len - 8;
                    //Found Atom search next atom
                    continue outter;
                } else {
                    //Skip Atom
                    in.skip(len - 8);
                    atom_size -= len;
                }
            }
            in.close();
            return null;
        }
        in.skip(8);
        byte buffer[] = new byte[atom_size - 8];
        in.read(buffer);
        in.close();
        return new String(buffer);
    }

