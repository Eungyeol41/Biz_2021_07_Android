package com.ini.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ini.library.adapter.BookAdapter;
import com.ini.library.databinding.FragmentFirstBinding;
import com.ini.library.model.BookDTO;
import com.ini.library.service.NaverAPIServiceV1;

import java.util.List;

public class FirstFragment extends Fragment {

    // 'fragment_first.xml을 Binding하라' 라는 의미가 된다.
    // *.xml 파일이 마치 java class가 된 것처럼 코딩을 할 수 있다.
    private FragmentFirstBinding binding;

    private BookAdapter bookAdapter;
    private List<BookDTO> bookDTOList;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bookAdapter = null; // = new BookAdapter();
        /*
         * Adapter를 생성하고 Adapter와 RecyclerView를 연결하는 코드를 Activity, Fragment와 같은 부분에서 처리를 해야하는 데...
         *
         * NaverAPIServiceV1에게 역할을 대신 수행하도록 한다.
         * 그러기 위해서 Adapter, RecyclerView 등이 담긴 binding 객체를 생성자의 매개변수로 전달한다.
         */
        NaverAPIServiceV1 nService = new NaverAPIServiceV1(bookAdapter, binding);
        nService.getNaverBooks("백신 예방");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}