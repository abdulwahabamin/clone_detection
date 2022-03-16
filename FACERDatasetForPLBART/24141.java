    public static String decodeGenre(String genre) {
        if (genre != null && genre.length() > 2 && genre.charAt(0) == '(' && genre.charAt(genre.length()-1) == ')') {
            try {
                return GENRE_NAMES[Integer.parseInt(genre.substring(1, genre.length()-1))];
            } catch (NumberFormatException e) {
                return genre;
            } catch (ArrayIndexOutOfBoundsException e) {
                return genre;
            }
        } else {
            try {
                return GENRE_NAMES[Integer.parseInt(genre)];
            } catch (NumberFormatException e) {
                return genre;
            } catch (ArrayIndexOutOfBoundsException e) {
                return genre;
            }
        }
    }

