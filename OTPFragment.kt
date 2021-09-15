package com.qoinpay.framwork.presentation.module.otp

import `in`.aabhasjindal.otptextview.OTPListener
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.qoinpay.R
import com.qoinpay.base.presentation.fragment.BaseContainerFragment
import com.qoinpay.databinding.FragmentOTPBinding
import com.qoinpay.extensionFunction.click
import com.qoinpay.extensionFunction.pressBack
import com.qoinpay.extensionFunction.toast
import com.qoinpay.framwork.presentation.navHost.HomeActivity

class OTPFragment : BaseContainerFragment<FragmentOTPBinding>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_o_t_p

    private lateinit var binding:FragmentOTPBinding
    private lateinit var otp: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getViewDataBinding()

        Clicks()
        OTP()
    }

    private fun Clicks() {
        binding.up.pressBack()

        binding.submitBtn.click {
//            binding.congratsLayout.visibility =View.VISIBLE
//            binding.otpLayout.visibility =View.GONE

            moveNext(R.id.action_otpFragment_to_verifyFragment)
        }
    }

    private fun OTP() {
        binding.otpView.otpListener = object : OTPListener {
            override fun onInteractionListener() {
//                binding.BtnOTPContinue.isEnabled = false
//                binding.BtnOTPContinue.background = resources.getDrawable(R.drawable.button_disable)
            }

            override fun onOTPComplete(otp: String) {
                this@OTPFragment.otp = otp
//                binding.BtnOTPContinue.isEnabled = true
//                binding.BtnOTPContinue.background = resources.getDrawable(R.drawable.button_bg)
            }

        }
    }


}