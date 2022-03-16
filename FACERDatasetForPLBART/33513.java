    private boolean doesQueryContainAnyLetters() {
        for (int i = 0; i < query.length(); i++) {
            if (Character.isLetter(query.charAt(i))) {
                return true;
            }
        }
        return false;
    }

