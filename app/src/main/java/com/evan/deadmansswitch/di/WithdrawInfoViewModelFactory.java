package com.evan.deadmansswitch.di;



import com.evan.deadmansswitch.viewmodel.WithdrawInfoViewModel;

import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface WithdrawInfoViewModelFactory {
    WithdrawInfoViewModel create(String contractAddress);
}
