package com.ini.hello

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ini.hello.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    /*
    * _firstFragment가 외부에서 어떤 이유로 값이 변경이 되면 firstFragment 자체에도 문제가 생길 수 있다.
    * 때문에 _firstFragment를 불변 객체로 선언하고 firstFragment만 외부로 보내서 사용을 하게 만든다.
    */

    /**
     * Fragment Binding하기
     * 1. null값으로 초기화하기
     */
    private var _firstFragment: FragmentFirstBinding? = null

    // _firstFragment에 있는 모든 속성을 firstFragment에 복제하는 것
    /**
     * _firstFragment와 fragment의 모든 속성을 연결하여
     * _firstFragment 현재 클래스에서 safe 데이터 형식으로 값을 설정하고
     * 외부로 전송할 때는 get()가 설정된 firstFragment를 사용하는 다소 독특한 방식.
     *
     * 내부 클래스에서 변경되는 변수가 외부로 전달될 때 문제를 일으킬 수 있기 때문에
     * 외부에서는 변수값을 변경하지 못하도록 immutable(불변) 객체로 변환하는 작업
     */
    private val firstFragment get() = _firstFragment!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        firstFragment = FragmentFirstBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // firstFragment = FragmentFirstBinding.inflate(inflater, container, false)
        _firstFragment = FragmentFirstBinding.inflate(inflater, container, false)

//        return inflater.inflate(R.layout.fragment_first, container, false)
        return firstFragment.root
    }
}
