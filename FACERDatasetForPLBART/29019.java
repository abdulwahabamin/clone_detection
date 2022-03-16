    private String charArrayUpperCaser(CharSequence sequence) {
        Character charAt = sequence.charAt(0);
        String s = sequence.toString().replace(sequence.charAt(0), charAt.toString().toUpperCase().charAt(0));
        Log.d(TAG, "charArrayUpperCaser: " + s);
        return s;
    }

