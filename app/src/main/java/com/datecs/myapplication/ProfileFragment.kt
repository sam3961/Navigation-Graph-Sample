package com.datecs.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import com.datecs.myapplication.databinding.FragmentProfileBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogout.setOnClickListener {
            findNavController().navigate(R.id.action_ProfileFragment_to_nav_auth_graph)
        }


        binding.buttonTurnOnNotification.setOnClickListener {
            //explicit deep linking

            val pendingIntent = NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.nav_home_graph)
                .setDestination(R.id.HomeFragment)
                .setArguments(bundleOf("data" to "b"))
                .setComponentName(HomeActivity::class.java)
                .createPendingIntent()

            val notification = NotificationCompat.Builder(
                requireContext(),
                requireContext().getString(R.string.app_name)
            )
                .setContentIntent(pendingIntent)
                .setContentText(getString(R.string.hello))
                .setContentTitle(getString(R.string.app_name))
                .setSmallIcon(R.mipmap.ic_launcher)
                .build()


            val notificationManager =
                context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(createNotificationChannel())
            notificationManager.notify(0, notification)


        }


        binding.buttonPrivacyPolicy.setOnClickListener {
            //Implicit Deep Linking
            val uri = Uri.parse("app://webview=${"www.freeprivacypolicy.com"}")
            findNavController().navigate(uri)

        }
        binding.buttonTermsAndCondition.setOnClickListener {
            //Implicit Deep Linking
            val uri = Uri.parse("app://webview=${"www.termsfeed.com"}")
            findNavController().navigate(uri)

        }


    }

    private fun createNotificationChannel(): NotificationChannel {
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_ALARM)
            .build()
        val importance = NotificationManager.IMPORTANCE_HIGH
        val notificationChannel = NotificationChannel(
            getString(R.string.app_name),
            "Navigation Component",
            importance
        )
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern =
            longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationChannel.setSound(
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION),
            audioAttributes
        )

        return notificationChannel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}