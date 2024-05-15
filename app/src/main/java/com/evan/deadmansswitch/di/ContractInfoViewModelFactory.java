package com.evan.deadmansswitch.di;

import com.evan.deadmansswitch.viewmodel.ContractInfoViewModel;

import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface ContractInfoViewModelFactory {
    ContractInfoViewModel create(String contractAddress);
}
