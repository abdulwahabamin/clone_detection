    private static String getLyricsVorbis(File file) throws Exception {
        FileInputStream in = new FileInputStream(file);
        int bytesinpage = 0;
        byte buffer[] = new byte[7];
        bytesinpage = readOgg(buffer, in, bytesinpage, -1);
        if (!Arrays.equals(buffer, new byte[]{1, 'v', 'o', 'r', 'b', 'i', 's'})) {
            in.close();
            return null;
        }
        bytesinpage = readOgg(null, in, bytesinpage, 23);
        bytesinpage = readOgg(buffer, in, bytesinpage, -1);
        if (!Arrays.equals(buffer, new byte[]{3, 'v', 'o', 'r', 'b', 'i', 's'})) {
            in.close();
            return null;
        }
        byte length[] = new byte[4];
        bytesinpage = readOgg(length, in, bytesinpage, -1);
        bytesinpage = readOgg(null, in, bytesinpage, byteArrayToInt(length));
        bytesinpage = readOgg(length, in, bytesinpage, -1);
        int count = byteArrayToIntLE(length);
        while (count-- > 0) {
            bytesinpage = readOgg(length, in, bytesinpage, -1);
            int comment_len = byteArrayToIntLE(length);
            byte lyrics_tag[] = new byte[]{'L', 'Y', 'R', 'I', 'C', 'S', '='};
            if (comment_len <= lyrics_tag.length) {
                bytesinpage = readOgg(null, in, bytesinpage, comment_len);
                continue;
            }
            byte comment_probe[] = new byte[lyrics_tag.length];
            bytesinpage = readOgg(comment_probe, in, bytesinpage, -1);
            if (Arrays.equals(comment_probe, lyrics_tag)) {
                byte lyrics[] = new byte[comment_len - lyrics_tag.length];
                readOgg(lyrics, in, bytesinpage, -1);
                in.close();
                return new String(lyrics);
            } else {
                bytesinpage = readOgg(null, in, bytesinpage, comment_len - lyrics_tag.length);
            }
        }
        in.close();
        return null;

    }

