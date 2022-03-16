        public static String[] names() {
            MimeTypeCategory[] categories = values();
            String[] names = new String[categories.length];

            for (int i = 0; i < categories.length; i++) {
                names[i] = categories[i].name();
            }

            return names;
        }

