package com.receive.myreceive

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.receive.myreceive.databinding.FragmentNextBinding

/**
 * Created by K.Kobayashi on 2022/08/25.
 */
class NextFragment : Fragment(R.layout.fragment_next) {
    private var _binding: FragmentNextBinding? = null
    private val binding: FragmentNextBinding get() = _binding!!
    private val args: NextFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(v: View) {
        this._binding = FragmentNextBinding.bind(v)
        binding.txtNum.text = args.num.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}