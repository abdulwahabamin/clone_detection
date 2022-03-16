    @SuppressWarnings("unchecked")
    private static PromptingKeyProvider<AesCipherParameters> getKeyProvider() {
        PromptingKeyManager<AesCipherParameters> keyManager =
                (PromptingKeyManager<AesCipherParameters>) Boot.MANAGERS.get(
                        AesCipherParameters.class);
         return (PromptingKeyProvider<AesCipherParameters>) keyManager.getKeyProvider(
                 SecureConsole.getSecureStorageRootUri());
    }

