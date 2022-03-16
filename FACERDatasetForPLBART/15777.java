        @Override
        public void doBackground() {
            if(new File(imagePath).exists()) {
                artDrawable = Drawable.createFromPath(imagePath);
            } else {
                artDrawable = null;
            }
        }

