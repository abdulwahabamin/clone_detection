        public static String[] getFriendlyLocalizedNames(Context context) {
            MimeTypeCategory[] categories = values();
            String[] localizedNames = new String[categories.length];

            for (int i = 0; i < categories.length; i++) {
                String description = getCategoryDescription(context, categories[i]);
                if (TextUtils.equals("-", description)) {
                    description = context.getString(R.string.category_all);
                }
                description = description.substring(0, 1).toUpperCase()
                        + description.substring(1).toLowerCase();
                localizedNames[i] = description;
            }

            return localizedNames;
        }

