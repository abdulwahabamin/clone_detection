        @Override
        protected Drawable doInBackground(String... args) {
            if (context == null) {
                return null;
            }

            String iconName = args[0];
            InputStream iconInputStream = getInputStream(iconName);
            if (iconInputStream == null) {
                // we return some placeholder icon
                return res.getDrawable(R.drawable.ic_launcher_weather);
            } else {
                Bitmap iconBitmap = BitmapFactory.decodeStream(iconInputStream);
                iconBitmap = MiscMethods.trimBitmap(iconBitmap);
                addIconToMemoryCache(iconName, iconBitmap);
                return new BitmapDrawable(res, iconBitmap);
            }
        }

