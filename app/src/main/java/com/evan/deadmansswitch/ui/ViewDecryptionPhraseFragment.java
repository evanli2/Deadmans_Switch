package com.evan.deadmansswitch.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evan.deadmansswitch.R;
import com.evan.deadmansswitch.adapters.ViewDecryptionPhraseAdapter;
import com.evan.deadmansswitch.di.ViewDecryptionPhraseViewModelFactory;
import com.evan.deadmansswitch.util.ClipboardUtil;
import com.evan.deadmansswitch.util.MnemonicItemDecoration;
import com.evan.deadmansswitch.util.SpacingUtils;
import com.evan.deadmansswitch.viewmodel.ViewDecryptionPhraseViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ViewDecryptionPhraseFragment extends DialogFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Inject
    ViewDecryptionPhraseViewModelFactory viewModelFactory;

    private static final int GRID_VIEW_SPACING = 16;
    private static final int GRID_VIEW_COLUMN_COUNT = 3;
    private final String contractAddress;
    private ViewDecryptionPhraseViewModel viewModel;
    private ViewDecryptionPhraseAdapter adapter;

    public ViewDecryptionPhraseFragment(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_DeadmansSwitch);

        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = R.style.FragmentSlideUpAnim;

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_decryption_phrase_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this,
                ViewDecryptionPhraseViewModel.provideFactory(viewModelFactory, contractAddress))
                .get(ViewDecryptionPhraseViewModel.class);

        viewModel.getLiveData().observe(getViewLifecycleOwner(), state -> {
            switch (state.getState()) {
                case SUCCESS_GET_DECRYPTION_PHRASE:
                    adapter.notifyDataSetChanged();
                    break;

                case ERROR:
                    Toast.makeText(requireContext(), R.string.unexpected_error, Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        adapter = new ViewDecryptionPhraseAdapter(viewModel.getWordList());

        int spacing = SpacingUtils.convertIntToDP(requireContext(), GRID_VIEW_SPACING);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), GRID_VIEW_COLUMN_COUNT);

        recyclerView.addItemDecoration(new MnemonicItemDecoration(GRID_VIEW_COLUMN_COUNT, spacing, true));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.queryDecryptionPhrase();
    }

    @OnClick(R.id.btn_close)
    void onClose() {
        dismiss();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.dispose();
    }

    @OnClick(R.id.btn_copy)
    void onCopy(){
        ClipboardUtil.copyText(requireContext(), viewModel.getDecryptionPhrase());
        Toast.makeText(requireContext(), "Copied", Toast.LENGTH_SHORT).show();
    }
}
