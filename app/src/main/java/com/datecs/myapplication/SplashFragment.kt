package com.datecs.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.datecs.myapplication.databinding.FragmentSplashBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
                findNavController().navigate(R.id.action_SplashFragment_to_LoginFragment)
        },2000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}