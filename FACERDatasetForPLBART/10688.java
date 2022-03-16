    /**
     * Method that check if a character is valid printable character
     *
     * @param c The character to check
     * @return boolean If the character is printable
     */
    public static boolean isPrintableCharacter(char c) {
        int cc = VALID_NON_PRINTABLE_CHARS.length;
        for (int i = 0; i < cc; i++) {
            if (c == VALID_NON_PRINTABLE_CHARS[i]) {
                return true;
            }
        }
        return TextUtils.isGraphic(c);
    }

