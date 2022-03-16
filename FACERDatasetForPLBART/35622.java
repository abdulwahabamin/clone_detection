        public DownLoadTask build() {
            if (entity.getUrl().isEmpty()) {
                throw new IllegalStateException("DownLoad URL required.");
            }

            if (listener == null) {
                throw new IllegalStateException("DownLoadTaskListener required.");
            }

            if (entity.getEnd() == 0) {
                throw new IllegalStateException("End required.");
            }
            return new DownLoadTask(entity, listener);
        }

