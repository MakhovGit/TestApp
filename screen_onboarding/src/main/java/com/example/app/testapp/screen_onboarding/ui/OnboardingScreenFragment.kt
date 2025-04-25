package com.example.app.testapp.screen_onboarding.ui

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Outline
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.HorizontalScrollView
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.app.testapp.core.data.ZERO
import com.example.app.testapp.navigation.data.navigation.MainNavigation
import com.example.app.testapp.screen_onboarding.databinding.FragmentScreenOnboardingBinding
import eightbitlab.com.blurview.BlurView

class OnboardingScreenFragment : Fragment() {
    private var _binding: FragmentScreenOnboardingBinding? = null
    private val binding get() = _binding!!
    private lateinit var darkTags: List<BlurView>

    private fun scrollToCenter(scroller: HorizontalScrollView) {
        scroller.post {
            val scrollX = (scroller.getChildAt(Int.ZERO).width - scroller.width) / 2
            scroller.scrollTo(scrollX, Int.ZERO)
        }
    }

    private fun applyBlur(blurView: BlurView, radius: Float, @ColorInt overlayColor: Int) {
        val decorView = requireActivity().window.decorView
        blurView.setupWith(decorView as ViewGroup)
            .setBlurRadius(radius)
            .setOverlayColor(overlayColor)
    }

    private fun fixViewCornersBlur(blurView: BlurView, cornerRadiusDp: Float) {
        val cornerRadiusPx = cornerRadiusDp * Resources.getSystem().displayMetrics.density
        blurView.apply {
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(
                        Int.ZERO,
                        Int.ZERO,
                        view.width,
                        view.height,
                        cornerRadiusPx
                    )
                }
            }
            clipToOutline = true
        }
    }

    private fun getDarkTagsList(): List<BlurView> {
        return listOf(
            binding.blurView1,
            binding.blurView2,
            binding.blurView3,
        )
    }

    private fun applyAllBlurTags() {
        for (tag in darkTags) {
            applyBlur(
                blurView = tag,
                radius = BLUR_RADIUS,
                overlayColor = Color.argb(BLUR_ALPHA, Int.ZERO, Int.ZERO, Int.ZERO)
            )
            fixViewCornersBlur(blurView = tag, cornerRadiusDp = 30f)
        }
    }

    private fun initButton() {
        binding.btnSubmit.setOnClickListener {
            val navigation = activity as? MainNavigation
            navigation?.openLoginScreen()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScreenOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        darkTags = getDarkTagsList()
        scrollToCenter(scroller = binding.hsvTagsScroller)
        applyAllBlurTags()
        initButton()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val BLUR_ALPHA = 10
        private const val BLUR_RADIUS = 10f
    }
}