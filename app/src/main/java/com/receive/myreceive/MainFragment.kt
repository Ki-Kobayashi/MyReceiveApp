package com.receive.myreceive

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.receive.myreceive.commom.consts.Constants
import com.receive.myreceive.databinding.FragmentMainBinding
import java.security.SecureRandom
import java.util.*
import android.content.BroadcastReceiver as BroadcastReceiver

/**
 * Created by K.Kobayashi on 2022/08/21.
 */
class MainFragment : Fragment(R.layout.fragment_main) {
    companion object {
        const val TAG = "MainFragment"
    }

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!
    private val mResultReceiver: BroadcastReceiver? by lazy {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(v: View) {
        _binding = FragmentMainBinding.bind(v)
        binding.button.setOnClickListener {
            Navigation.findNavController(v).navigate(
                MainFragmentDirections.actionMainFragmentToNextFragment(
                    SecureRandom().nextInt(100)
                )
            )
        }
        binding.btnPrivateRc.setOnClickListener {
            val intent = Intent(context, PrivateReceiver::class.java).apply {
                putExtra(Constants.PRIVATE_BC_MSG, Date().toString())
            }
            // 通常はサービスから行うもの？
            requireContext().sendOrderedBroadcast(intent, null,)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setResultReceiver(): BroadcastReceiver {
        return object: BroadcastReceiver() {
            override fun onReceive(ctx: Context, intent: Intent) {

            }

        }
    }
}