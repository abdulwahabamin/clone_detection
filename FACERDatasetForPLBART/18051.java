                @Override
                public int compare(MediaMetadataCompat o1, MediaMetadataCompat o2) {
                    return o1
                            .getString(MusicProviderSource.CUSTOM_METADATA_KEY_DATE_MODIFIED)
                            .compareTo(
                                    o2.getString(MusicProviderSource.CUSTOM_METADATA_KEY_DATE_MODIFIED));
                }

