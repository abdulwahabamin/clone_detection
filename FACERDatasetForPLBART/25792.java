        @Override
        public void updateItem(LifeItemData lifeItemData, int position) {
            weatherLifeIndexData = lifeItemData.getWeatherLifeIndexData();
            if (Check.isNull(weatherLifeIndexData)) {
                return;
            }
            lifeType.setText(weatherLifeIndexData.getName());
            lifeLevel.setText(weatherLifeIndexData.getLevel());
            lifeIndexIcon.setImageResource(lifeItemData.lifeIndexIconId);
        }

