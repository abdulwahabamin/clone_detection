        @Override
        public void onResult(DataItemBuffer dataItems) {
            if (dataItems.getCount() != 0) {
                DataMap dataMap = DataMapItem.fromDataItem(dataItems.get(0)).getDataMap();

            }

            dataItems.release();
        }

