    public static boolean isValidFilename(String s)
    {
        int len = s.length();
        if (len > FILENAME_LEN_MAX || len == 0) {
            return false;
        }

        for (int i = 0; i < ILLEGAL_CHARS.length; i ++)
        {
            if (s.contains(ILLEGAL_CHARS[i]))
            {
                return false;
            }
        }
        if (s.charAt(len - 1) == '.')
        {
            return false;
        }
        return true;
    }

