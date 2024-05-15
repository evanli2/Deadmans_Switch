package com.evan.deadmansswitch.di;



import com.evan.deadmansswitch.viewmodel.ViewDecryptionPhraseViewModel;

import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface ViewDecryptionPhraseViewModelFactory {
    ViewDecryptionPhraseViewModel create(String contractAddress);
}
