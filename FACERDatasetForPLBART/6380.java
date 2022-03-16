        @Override
        public DocumentInfo createFromParcel(Parcel in) {
            final DocumentInfo doc = new DocumentInfo();
            DurableUtils.readFromParcel(in, doc);
            return doc;
        }

